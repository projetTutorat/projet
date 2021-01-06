package InterfaceConnexion;

import java.io.IOException;

/**
 * Class pour le mot de passe oublié
 */
public class BrowserControl
{

    /**
     * La méthode displayURL est static et ne retourne rien.
     * Elle permet de lancer le porcess du cmd
     *
     * @param url
     *          L'url
     */
    public static void displayURL(String url)
    {
        boolean windows = isWindowsPlatform();
        String cmd = null;
        try
        {
            if (windows)
            {
                
                cmd = WIN_PATH + " " + WIN_FLAG + " " + url;
                Process p = Runtime.getRuntime().exec(cmd);
            }
            else
            {
               
                cmd = UNIX_PATH + " " + UNIX_FLAG + "(" + url + ")";
                Process p = Runtime.getRuntime().exec(cmd);
                try
                {
                    int exitCode = p.waitFor();
                    if (exitCode != 0)
                    {
                       
                        cmd = UNIX_PATH + " "  + url;
                        p = Runtime.getRuntime().exec(cmd);
                    }
                }
                catch(InterruptedException x)
                {
                    System.err.println("Error bringing up browser, cmd='" +
                                       cmd + "'");
                    System.err.println("Caught: " + x);
                }
            }
        }
        catch(IOException x)
        {
            // couldn't exec browser
            System.err.println("Could not invoke browser, command=" + cmd);
            System.err.println("Caught: " + x);
        }
    }
    /**
     * La méthode isWindowsPlatform est static et retourne un boolean.
     * Elle permet de vérifier si l'os de l'utilisateur est bien Windows.
     *
     * @return
     */
    public static boolean isWindowsPlatform()
    {
        String os = System.getProperty("os.name");
        if ( os != null && os.startsWith(WIN_ID))
            return true;
        else
            return false;
    }
    /**
     * La méthode main est static et ne retourne rien.
     *
     * @param args
     *          L'argument
     */
    public static void main(String[] args)
    {
        displayURL("http://www.javaworld.com");
    }
    // Used to identify the windows platform.
    private static final String WIN_ID = "Windows";
    // The default system browser under windows.
    private static final String WIN_PATH = "rundll32";
    // The flag to display a url.
    private static final String WIN_FLAG = "url.dll,FileProtocolHandler";
    // The default browser under unix.
    private static final String UNIX_PATH = "netscape";
    // The flag to display a url.
    private static final String UNIX_FLAG = "-remote openURL";
}