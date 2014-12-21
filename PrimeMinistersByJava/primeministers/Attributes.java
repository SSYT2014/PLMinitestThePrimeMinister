package primeministers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 */
public class Attributes extends Object
{
	/**
	 * 属性リストのキー群を記憶するフィールド。
	 */
	private ArrayList<String> keys;
	/**
	 * 属性リストの名前群を記憶するフィールド。
	 */
	private ArrayList<String> names;

	/**
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 * @param aString
	 */
	Attributes(String aString){
		if(aString.equals("output")){
			this.names=new ArrayList<String>(Arrays.asList("人目","代","氏名","ふりがな","在位期間","在位日数","出身校","政党","出身地","画像"));
			this.keys=new ArrayList<String>(Arrays.asList("id","no","name","ruby","util","period","school","party","country","img","thum","link"));
			
		}else if(aString.equals("input")){
			this.names=new ArrayList<String>(Arrays.asList("人目","代","氏名","ふりがな","在位期間","出身校","政党","出身地","画像","縮小画像"));
			this.keys=new ArrayList<String>(Arrays.asList("id","no","name","ruby","util","school","party","country","img","thum"));
			
		}
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。名前が無いときはキーを応答する。
	 * @param index
	 * @return　keys or names
	 */
	protected String at(int index){
		if(names.contains(index)){
			return this.names.get(index);
		}else{
			return this.keys.get(index);
		}
	}
	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 * @param aString
	 * @return index
	 */
	@SuppressWarnings("unused")
	private int indexOf(String aString){
		int index=this.keys.indexOf(aString);
		return index;
	}
	/**
	 * 在位日数のインデックスを応答する。
	 * @return index
	 */
	public int indexOfDays(){
		int index = this.keys.indexOf("period");
		return index;
	}

	/**
	 * 画像のインデックスを応答する。
	 * @return index
	 */
	public int indexOfImage(){
		int index = this.keys.indexOf("img");
		return index;
	}
	/**
	 * ふりがなのインデックスを応答する。
	 * @return index
	 */
	public int indexOfKana(){
		int index = this.keys.indexOf("ruby");
		return index;
	}
	/**
	 * 氏名のインデックスを応答する。
	 * @return index
	 */
	public int indexOfName(){
		int index = this.keys.indexOf("name");
		return index;

	}

	/**
	 * 番号のインデックスを応答する。
	 * @return index
	 */
	public int indexOfNo(){
		int index = this.keys.indexOf("id");
		return index;

	}

	/**
	 * 代のインデックスを応答する。
	 * @return index
	 */
	public int indexOfOrder(){
		int index = this.keys.indexOf("no");
		return index;

	}

	/**
	 * 政党のインデックスを応答する。
	 * @return index
	 */
	public int indexOfParty(){
		int index = this.keys.indexOf("party");
		return index;

	}

	/**
	 * 在位期間のインデックスを応答する。
	 * @return index
	 */
	public int indexOfPeriod(){
		int index = this.keys.indexOf("util");
		return index;

	}

	/**
	 * 出身地のインデックスを応答する。
	 * @return index
	 */
	public int indexOfPlace(){
		int index = this.keys.indexOf("country");
		return index;

	}

	/**
	 * 出身校のインデックスを応答する。
	 * @return index
	 */
	public int indexOfSchool(){
		int index = this.keys.indexOf("school");
		return index;

	}

	/**
	 * 画像のインデックスを応答する。
	 * @return index
	 */
	public int indexOfThumbnail(){
		int index = this.keys.indexOf("thum");
		return index;
	}

	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 * @param index
	 * @return key
	 */
	protected String keyAt(int index){
		String key=this.keys.get(index);
		return key;
	}

	/**
	 * キー群を応答する。
	 * @return this.keys
	 */
	public ArrayList<String> keys(){
		return this.keys;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 * @param index
	 * @return name
	 */
	protected String nameAt(int index){
		String name=this.names.get(index);
		return name;
	}

	/**
	 * 名前群を応答する。
	 * @return this.name
	 */
	public ArrayList<String> names(){
		return this.names;
	}

	/**
	 * 名前群を設定する。
	 * @param aCollection
	 */
	public void names(ArrayList<String> aCollection){
		this.names=aCollection;
	}

	/**
	 * 属性リストの長さを応答する。
	 * @return length
	 */
	public int size(){
		int length=this.names.size();
		return length;
	}


	/**
	 * 自分自身を文字列にして、それを応答する。
	 * @return aString
	 */
	public String toString(){
		String aString = super.toString();
		return aString;
	}
}
