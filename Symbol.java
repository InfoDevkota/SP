public class Symbol{
	public String symbol;
	public String value;
	public Symbol left;
	public Symbol right;
	public boolean flag;

	public Symbol(String symbol, String value, Symbol left, Symbol right, boolean flag){
		//TODO first check the string size
		this.symbol = symbol;
		this.value = value;
		this.left = left;
		this.right = right;
		this.flag = flag;
	}

	public String getSymbol(){
		return symbol;
	}
	public String toString(){
		String output = symbol + "\t" + value + "\t" + flag;
		return output;
	}
}
