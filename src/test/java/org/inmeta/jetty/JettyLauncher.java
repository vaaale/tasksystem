package org.inmeta.jetty;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * Created by IntelliJ IDEA.
 * User: alexanderv
 * Date: 27.okt.2009
 * Time: 13:02:39
 * To change this template use File | Settings | File Templates.
 */
public class JettyLauncher {

    public final static void main(String args[]) throws Exception {
        Server jetty = new Server();

        SocketConnector connector = new SocketConnector();
        connector.setPort(8080);
        jetty.addConnector(connector);


        WebAppContext context = new WebAppContext();
        context.setContextPath("/tasksystem");
        context.setWar("src/main/webapp");
        context.setDefaultsDescriptor("etc/jetty-webdefault.xml");
        jetty.addHandler(context);

        jetty.start();
        jetty.join();
    }
}
