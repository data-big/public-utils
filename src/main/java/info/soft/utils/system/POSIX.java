package info.soft.utils.system;

/**
 * 暂时不考虑该库
 *
 * @author gy
 *
 */
@Deprecated
public class POSIX {

	static {
		System.loadLibrary("POSIX");
	}

	native static int getpid();

}
