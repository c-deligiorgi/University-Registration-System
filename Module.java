package University;
/**
 * @author Christina Deligiorgi 
 *
 */


public class Module {

	private String moduleCode;
	private String moduleName;
	private int moduleCredits;
	
	
	public Module(String moduleCode, String moduleName, int moduleCredits) {
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.moduleCredits = moduleCredits;
	}


	@Override
	public String toString() {
		return moduleCode + " " + moduleName + " " + moduleCredits;
	}
	
	
	public int getModuleCredits() {
		return moduleCredits;
	}
	
	
	
	
}
