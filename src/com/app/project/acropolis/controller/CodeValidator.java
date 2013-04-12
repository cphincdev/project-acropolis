package com.app.project.acropolis.controller;

import java.util.Timer;

import loggers.Logger;

import com.app.project.acropolis.engine.monitor.CallMonitor_ver2;
import com.app.project.acropolis.engine.monitor.DataMonitor;
import com.app.project.acropolis.engine.monitor.LocationCode;
import com.app.project.acropolis.engine.monitor.TextMonitor;

/**
 * All the Engines, Handlers, Runnable are passed and verified
 * if all true then executed
 * @author Rohan Kumar Mahendroo <rohan.mahendroo@gmail.com>
 * @version $Revision: 1.0 $
 */
public class CodeValidator implements Runnable
{
	public CodeValidator()
	{
		new Logger().LogMessage("--->CodeValidator()<---");
	}
	
	/**
	 * Method run.
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		new Logger().LogMessage("Engine ready steady GOO!!..");
//		new Thread(new CallMonitor()).start();		//for application permission first run
		new CallMonitor_ver2();
		new TextMonitor();
		new Timer().schedule(new DataMonitor(),60*1000);
		new Thread(new RoamingHandler()).start();
		new Thread(new LocalHandler()).start();
	}
}
