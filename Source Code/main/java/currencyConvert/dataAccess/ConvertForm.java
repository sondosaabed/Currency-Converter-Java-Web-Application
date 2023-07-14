/**
 * 
 */
package currencyConvert.dataAccess;

/**
 * 
 */
public class ConvertForm {
	private String from;
	private String to;
	/**
	 * @param from
	 * @param to
	 */
	public ConvertForm(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}	
}