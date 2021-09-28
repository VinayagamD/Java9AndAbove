package com.vinaylogics.corejavatraining.exception;

/**
 * @author vinay
 *
 */
public class ExceptionExamples {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Throwable {
		try {
			if(true)
				throw new MyException(100, "My Exception");
		} catch( MyException e) {
			System.out.println(e.getExceptionCode());
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finally Executed");
		}

	}

	public void businessLogic() throws MyException {
		boolean businessLogicNotMet = true;
		if(businessLogicNotMet)
			throw new MyException(102, "They met the business Criteria");

	}
}
