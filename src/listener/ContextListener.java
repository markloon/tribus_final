package listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import hibernate.TribusHibernateSessionFactory;


public class ContextListener implements ServletContextListener {

	

	public static String SYSTEM_ALIAS = "tribus";

	private static String DEFAULT_FILTER_KEY = null;

	private String getSystemAlias( ServletContextEvent arg0 ) {
		try {
			ServletContext ctx = arg0.getServletContext( );
			return ContextListener.getContextParameter( ctx, "SystemAlias" );
		} catch ( Exception e ) {
			return null;
		}

	}

	public static String getContextParameter( ServletContext ctx, String name ) {
		String value = ctx.getInitParameter( name );
		if ( value != null ) {
			value = value.trim( );
		}
		return value;
	}

	private static void setDefaultFilterKey( ServletContextEvent arg0 ) {
		try {
			ServletContext ctx = arg0.getServletContext( );
			ContextListener.DEFAULT_FILTER_KEY = getContextParameter( ctx, "DefaultFilterKey" );
//			cat.info( "load DefaultFilterKey from Context: " + ContextListener.DEFAULT_FILTER_KEY );
		} catch ( Exception e ) {
			ContextListener.DEFAULT_FILTER_KEY = null;
		}
	}

	public static String getDefaultFilterKey( ) {
		return ContextListener.DEFAULT_FILTER_KEY;
	}

	/*
	 * initialize. create instance of system<br><br> if you want to convert
	 * the encoding before insert to DB, you should put config like this:<br>
	 * <pre> &lt;charset&gt; &lt;env&gt;ISO-8859-1&lt;/env&gt;
	 * &lt;db&gt;GBK&lt;/db&gt; &lt;/charset&gt; </pre>
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	public void contextInitialized( ServletContextEvent arg0 ) {
		try {
			String sa = this.getSystemAlias( arg0 );
			if ( sa != null && sa.length( ) > 0 ) {
				ContextListener.SYSTEM_ALIAS = sa;
			}

			/**
			 * initial the log4j properties.
			 */
			String path = SYSTEM_ALIAS + ".log4j.properties";
			
			String pic_base_path = "";
			
//			URL configUrl = PropertyManager.getResourceURL( path );
//			if ( configUrl != null ) {
//				PropertyConfigurator.configure( configUrl );
//			}
//
//			cat = Logger.getLogger( ContextListener.class.getName( ) );
//StringUtils.formatDate( new Date( ) )
//			String s = "\n*********************************************************************************************************\n"
//					+ "*********************************************************************************************************\n"
//					+ "                  " + SYSTEM_ALIAS.toUpperCase( ) + " System Restart At  " + 
//					+ "\n" + "*********************************************************************************************************\n"
//					+ "*********************************************************************************************************\n";
//			cat.info( s );

			ContextListener.setDefaultFilterKey( arg0 );
			TribusHibernateSessionFactory.currentSession();
			
			/**
			 * initial the application configuration.
			 */
			String configFileName = ContextListener.SYSTEM_ALIAS + ".application.xml";
//			cat.info( "load application configure [" + configFileName + "]" );
//
//			PropertyManager.getInstance( ContextListener.SYSTEM_ALIAS, configFileName );
//
//			String envset = PropertyManager.getString( ContextListener.SYSTEM_ALIAS, "charset.env" );
//
//			String dbset = PropertyManager.getString( ContextListener.SYSTEM_ALIAS, "charset.db" );
//
//			if ( envset != null && dbset != null ) {
//				cat.info( "set ENV_CHARSET=" + envset + ", DB_CHARSET=" + dbset );
//				StringUtils.setCharSet( envset, dbset );
//			}

			// Load the class and create an instance.
//			cat.info( " begin to create ManagerFactory:" );
//			ManagerFactory factory = ManagerFactory.getInstance( ContextListener.SYSTEM_ALIAS, PropertyManager.getInstance(
//					ContextListener.SYSTEM_ALIAS ).getConfig( ) );
//
//			DataAccessObjFactory.getInstance( );

			try {
//				UserManager um = UserManager.getInstance( );
//				factory.addManager( um );
			} catch ( Exception e ) {
				e.printStackTrace( );
			}


//			ServiceManager sm = ServiceManager.getInstance( factory );
//			factory.addManager( sm );

//			SystemCategoryManager scm = SystemCategoryManager.getInstance( factory );
//			factory.addManager( scm );

//			SystemItemManager sim = SystemItemManager.getInstance( factory );
//			factory.addManager( sim );
//
//			PreviewManager pm = PreviewManager.getInstance( factory );
//			factory.addManager( pm );
//
//			AdminGroupManager agm = AdminGroupManager.getInstance( factory );
//			factory.addManager( agm );
//
//			IconManager im = IconManager.getInstance( factory );
//			factory.addManager( im );
//
//			OperationFlowManager.getInstance( );
//
//			InterceptorChainFactory.getInstance( PropertyManager.getInstance( ContextListener.SYSTEM_ALIAS ).getConfig( ) );

		} catch ( Exception e ) {
//			cat.error( "Load System catch: ", e );
		}
	}

	/*
	 * destroy.
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	public void contextDestroyed( ServletContextEvent arg0 ) {
//		cat.info( "\n*********************************************************************************************************\n"
//				+ "*********************************************************************************************************\n"
//				+ "                  " + SYSTEM_ALIAS.toUpperCase( ) + " System Destroyed At  " + StringUtils.formatDate( new Date( ) )
//				+ "\n" + "*********************************************************************************************************\n"
//				+ "*********************************************************************************************************\n" );
	}

}
