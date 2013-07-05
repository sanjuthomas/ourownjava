package com.ourownjava.corejava.jboss;

import java.util.Properties;
import javax.naming.*;

/**
 * @author ourownjava.com
 * @date May 3rd, 2011
 *
 * Example program to print JBoss JNDI tree
 *
 */public class JNDIClientExample {
	public static void main(String args[]) throws Exception {
		final Properties props = new Properties();
		//create the initial context.
		//change the IP address as per your environment
		props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
		"org.jnp.interfaces.NamingContextFactory");
		props.put(InitialContext.PROVIDER_URL, "jnp://127.0.0.1:1099");
		final Context context = new InitialContext(props);
		final NamingEnumeration<?> enumeration = context.list("/");
		while (enumeration.hasMore()) {
			System.out.println(enumeration.next());
		}
	}
}