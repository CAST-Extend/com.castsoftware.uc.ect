package com.castsoftware.enlighten.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.castsoftware.enlighten.config.EnlightenProfileConfig;
import com.castsoftware.enlighten.model.AADApplication;
import com.castsoftware.enlighten.model.AADPortal;
import com.castsoftware.enlighten.model.ApplForm;

@Controller
public class ApplSelectControler {
	private static final Logger log = LoggerFactory.getLogger(ApplSelectControler.class);

	private final String ERROR_MSG = "errorMsg";
	private final String GOOD_MSG = "goodMsg";

	@Autowired
	private AADController restAAD;

	@Autowired
	private EnlightenProfileConfig epc;

	@RequestMapping(value = "/")
	public String frame(Model model) {
		ApplForm form = new ApplForm();

		try {
			form.setApplList(applSelect());
		} catch (Throwable ex) {
			form.setApplList(new ArrayList());
			model.addAttribute(ERROR_MSG, ex.getMessage());
		}
		form.setConfigList(new ArrayList());
		model.addAttribute("formData", form);

		return "frame";
	}

	@RequestMapping(value = "/addAppls", method = RequestMethod.POST)
	public String addAppls(@ModelAttribute ApplForm form, Model model) {
		ArrayList<String> configList = form.getConfigList();
		try {
			ArrayList<AADApplication> applList = applSelect();

			form.setApplList(applList);
			form.setConfigList(configList);
			model.addAttribute("formData", form);

			File profileFile = findProfilePath();
			if (profileFile == null) {
				model.addAttribute(ERROR_MSG, "Unable to locate Enlighten profile");
			} else {
				BufferedWriter writer = null;
				try {
					String fileName = profileFile.getAbsolutePath();
					writer = new BufferedWriter(new FileWriter(fileName));

					for (String thisApp : configList) {
						for (AADApplication aadApp : applList) {
							if (thisApp.equals(aadApp.getName())) {
								writer.write(createApplProfile(aadApp));
								applList.remove(aadApp);
								break;
							}
						}
					}
					writer.close();
					model.addAttribute(GOOD_MSG, "Profile written successfully!");

				} catch (IOException e) {
					model.addAttribute(ERROR_MSG, e.getMessage());
					log.error("Error writing to enlighten profile file", e);
				}
			}
		} catch (Exception e) {
			model.addAttribute(ERROR_MSG, e.getMessage());
			form.setApplList(new ArrayList());
			model.addAttribute("formData", form);
			log.error("Error writing to enlighten profile file", e);
		}
		return "frame";
	}

	private String createApplProfile(AADApplication appl) {
		StringBuffer profile = new StringBuffer();
		String applName = appl.getName();
		String centralDB = appl.getAdgDatabase();

		String replaceFrom = "_central";
		String localDB = centralDB.replace(replaceFrom, "_local");
		if (localDB.equals(centralDB)) {
			for (int ii = replaceFrom.length() - 1; ii < 0; ii--) {
				localDB = centralDB.replace(replaceFrom.substring(0, ii), "_local");
				if (!localDB.equals(centralDB)) {
					break;
				}
			}
		}

		String serverInfo = String.format("%s:%s on CastStorageService", epc.getServer(), epc.getPort());
		String id = String.format("%s.%s", serverInfo, localDB);
		String pw =  epc.getPassword();
		
		profile.append(String.format("[%s]\n", id))
		       .append(String.format("1=s%s\n", id))
		       .append("10=b1\n")
		       .append("13=i4\n")
		       .append(String.format("2=s%s:%s\n", epc.getServer(), epc.getPort()))
		       .append(String.format("27=s%s\n", localDB))
		       .append(String.format("3=s%s\n", epc.getUser()))
		       .append("32=s\n")
		       .append(String.format("38=s%s\n", pw))
		       .append("39=b0\n")
		       .append("41=i22\n")
		       .append("54=i2\n")
		       .append(String.format("55=sLIBPQ:%s:%s,postgres\n", epc.getServer(), epc.getPort()))
		       .append("8=i303\n")
		       .append("9=i303\n");

		return profile.toString();
	}

	private File findProfilePath() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		int posi = userName.indexOf("@");
		if (posi > 0)
		{
			userName = userName.substring(0, posi);
		}
		
		File profilePath = new File(String.format("%s/%s", epc.getProfileBaseFolder(), userName));

		if (!profilePath.exists()) {
			profilePath.mkdirs();
		}
		return new File(String.format("%s/CWProfileConnection.ini", profilePath.getAbsolutePath()));
	}

	public ArrayList<AADApplication> applSelect() throws UnknownHostException {
		String version = epc.getVersion();
		ArrayList<AADApplication> applList = new ArrayList<AADApplication>();

		List<AADPortal> portals = restAAD.getPortals();
		for (AADPortal p : portals) {
			String portalName = p.getName();
			String portalVersion = p.getDbmsVersion();

			List<AADApplication> appls = restAAD.getApplications(portalName);

			for (AADApplication aa : appls) {
				if (aa.getAdgVersion().contains(version)) {
					applList.add(aa);
				}

				// //is the application already on the list?
				// for (AADApplication bb: applList)
				// {
				// if (aa.getName().equals(bb.getName()))
				// {
				// // it is on the list, we only want to keep the latest version
				// int oldVersion = Integer.parseInt(bb.getAdgVersion());
				// int newVersion = Integer.parseInt(aa.getAdgVersion());
				// if (oldVersion < newVersion)
				// {
				// applList.remove(bb);
				// }
				// break;
				// }
				// }
				//
				// applList.add(aa);
			}
		}
		return applList;

	}

}
