import java.util.Scanner;

public class SymbolTable{
	public static Symbol root;
	
	public static void main(String args[]){
		try {
			System.out.println("Hello World");
			System.out.println("Roll: 161745\nName: Sagar Devkota[devkotasagar.com.np]\nBE Software Morning");
			boolean again = true;
			while(again = true){
				System.out.println("---------------------------------------");
				System.out.println("|Menu");
				System.out.println("|1\tEnter Symbol");
				System.out.println("|2\tSearch Symbol");
				System.out.println("|3\tPrint Symbols Inorder");
				System.out.println("|9\t ***Exit***");
				System.out.println("|0\t ***Again***");
				System.out.println("---------------------------------------");
				int option;
				Scanner aScanner = new Scanner(System.in);
				System.out.print("Please Enter option:- ");
				option = aScanner.nextInt();
				if(option == 1){
					enterSymbol();
				}
				if(option == 2){
					searchSymbol();
				}
				if(option == 3){
					System.out.println("Printing in Inorder");
					System.out.println("Symbol\tValue\tFlag");
					inOrder(root);
				}
				if(option == 9){
					return;
				}
				if(option == 0){
					again = true;
				}
			}
		} catch (Exception e){
			System.out.println("Something went Wrong Please Try again");
		}
	}

	public static void enterSymbol(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter \nSymbol\tValue\tFlag");
		String data = input.nextLine();
		String symbol = data.split("\\s+")[0];//Here \\s+ is a greedy regular expression, Greedy because there is + \s will match any whitespace including tabs. and we need \ for escaping.
		int given = (int) symbol.charAt(0);
		int first = (int) '0';
		int last = (int) '9';
		if(given > first && given < last){
			System.out.println("Illegal Symbol");
			return;
		}
		String value = data.split("\\s+")[1];
		String flagString = data.split("\\s+")[2];
		boolean flag;
		if(flagString == "TRUE")
			flag = true;
		else
			flag = false;
			
		String finalSymbol = "";
		if(symbol.length()>5){
			for(int i = 0; i <6 ; i++){
				finalSymbol = finalSymbol + Character.toString(symbol.charAt(i));
			}
		} else {
			finalSymbol = symbol;
		}
		root = insert(root,finalSymbol,value,flag);
	}
	
	public static void searchSymbol(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Symbol to Search");
		String data = input.nextLine();
		String symbol = data.split("\\s+")[0];
		search(root, symbol);
	}
		
	
	public static Symbol insert(Symbol node, String symbol, String value, boolean flag){
		if(node == null){
			node = new Symbol(symbol,value,null,null,flag);
			return node;
		} else {
			//the compareTo method on String
			//returns > 0 if this string is greater than argument.
			//returns = 0  is equal
			//returns < 0 if this is less than the args.
			if(node.getSymbol().compareTo(symbol) > 0){
				//os the new symbol is less
				node.left = insert(node.left,symbol,value,flag);
			} else if(node.getSymbol().compareTo(symbol) < 0){
				//os the new symbol is greater
				node.right = insert(node.right,symbol,value,flag);
			} else {
				System.out.println("Duplicate Symbol");
			}
		}
		return node;
	}
	
	public static void search(Symbol node, String text){
		if(node.getSymbol().compareTo(text) == 0){	
			System.out.println("Found");
			System.out.println(node);
			return;	
		}
		if(node == null){
			System.out.println("Not Found");
			return;	
		}
		if(node.getSymbol().compareTo(text) > 0){
			//os the new symbol is less
			search(node.left, text);
		}
		if(node.getSymbol().compareTo(text) < 0){
			//os the new symbol is greater
			search(node.right, text);
		}
	}
	
	public static void inOrder(Symbol node){
		if(node == null){
			return;
		}
		inOrder(node.left);
		System.out.println(node);
		inOrder(node.right);
	}
}
