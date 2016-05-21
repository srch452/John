package John.src.main.java.Utils;

import org.jcp.xml.dsig.internal.dom.Utils;

/**
 * Created by suzi on 21/05/16.
 */
public class Logger {
    private static Class<Utils.Utils.VerifyUtils> verifyUtilsClass;

    public static Logger getLogger(Class<Utils.Utils.VerifyUtils> verifyUtilsClass) {
        Logger.verifyUtilsClass = verifyUtilsClass;
    }

    public static Logger getLogger(Class<Utils.VerifyUtils> verifyUtilsClass) {
    }
}
