
public class TestClass {

	public static void main(String[] args) {
		MagicSquareModel myModel=new MagicSquareModel(3);
		
		myModel.setValueAt("8", 0, 0);
		myModel.setValueAt("1", 0, 1);
		myModel.setValueAt("6", 0, 2);
		myModel.setValueAt("3", 1, 0);
		myModel.setValueAt("5", 1, 1);
		myModel.setValueAt("7", 1, 2);
		myModel.setValueAt("4", 2, 0);
		myModel.setValueAt("9", 2, 1);
		myModel.setValueAt("2", 2, 2);
		
		System.out.println(myModel.isMagic());
		System.out.println(myModel.isNormalMagic());

		myModel.clear();
		myModel.setValueAt("1", 0, 0);
		myModel.setValueAt("1", 0, 1);
		myModel.setValueAt("1", 0, 2);
		myModel.setValueAt("1", 1, 0);
		myModel.setValueAt("1", 1, 1);
		myModel.setValueAt("1", 1, 2);
		myModel.setValueAt("1", 2, 0);
		myModel.setValueAt("1", 2, 1);
		myModel.setValueAt("1", 2, 2);
		
		System.out.println(myModel.isMagic());
		System.out.println(myModel.isNormalMagic());
	}

}
