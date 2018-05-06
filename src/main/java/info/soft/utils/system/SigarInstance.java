package info.soft.utils.system;

import org.hyperic.sigar.Sigar;

/**
 * Sigar系统信息获取和报告服务
 *
 * @author gy
 *
 */
public class SigarInstance {

	private Sigar sigar;

	public synchronized Sigar getSigar() {
		if (sigar == null) {
			sigar = new Sigar();
		}
		return sigar;
	}

	public synchronized void forceRelease() {
		if (sigar != null) {
			sigar.close();
			sigar = null;
		}
	}

	public long getPid() {
		return getSigar().getPid();
	}

}
