package info.soft.utils.system;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * Java Native Access Platform
 *
 * @author gy
 *
 */
interface CLibrary extends Library {

	CLibrary INSTANCE = (CLibrary) Native.loadLibrary("c", CLibrary.class);

	int getpid();

}
