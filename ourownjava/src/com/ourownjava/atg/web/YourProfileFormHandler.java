package com.ourownjava.atg.web;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.commerce.profile.CommerceProfileFormHandler;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.userdirectory.UserDirectoryTools;

/**
 * @author ourownjava.com
 */
public class YourProfileFormHandler extends CommerceProfileFormHandler {

	private UserDirectoryTools userDirectoryTools;

	/**
	 * @param userDirectoryTools
	 *            the userDirectoryTools to set
	 */
	public void setUserDirectoryTools(UserDirectoryTools userDirectoryTools) {
		this.userDirectoryTools = userDirectoryTools;
	}

	@Override
	protected void postLoginUser(final DynamoHttpServletRequest request,
			final DynamoHttpServletResponse response) throws ServletException,
			IOException {
		// load roles from LDAP and map it to ATG roles.
		// userDirectoryTools.assignRolesToUser(<atg_roles>, <profile_id>);
	}

}