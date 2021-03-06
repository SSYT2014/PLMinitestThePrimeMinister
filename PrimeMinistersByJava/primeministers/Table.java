package primeministers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 表：総理大臣の情報テーブル。
 * 良好(2014年12月22日)
 */
public class Table extends Object
{
	/**
	 * 属性リストを記憶するフィールド。
	 * 良好(2014年12月22日)
	 */
	private Attributes attributes;
	/**
	 * タプル郡を記憶するフィールド。
	 * 良好(2014年12月22日)
	 */
	private ArrayList<Tuple> tuples;
	/**
	 * 画像群を記憶するフィールド。
	 * 良好、不使用(2014年12月22日)
	 * 
	 */
	private ArrayList<BufferedImage> images;
	/**
	 * サムネイル画像群を記憶するフィールド
	 * 良好、不使用(2014年12月22日)
	 */
	private ArrayList<BufferedImage> thumbnails;
	/**
	 * テーブルのコンストラクタ。
	 * 良好(2014年12月22日)
	 */
	Table(){
		this.tuples=new ArrayList<Tuple>();
		this.images=new ArrayList<BufferedImage>();
		this.thumbnails=new ArrayList<BufferedImage>();
		return;
	}
	/**
	 * タプルを追加する。
	 * 良好(2014年12月22日)
	 * @param aTuple
	 */
	public void add(Tuple aTuple){
		this.tuples.add(aTuple);
	}

	/**
	 * 属性リストを応答する。
	 * 良好(2014年12月22日)
	 * @return this.attributes
	 */
	public Attributes attributes(){
		return this.attributes;
	}
	/**
	 * 属性リストを設定する。
	 * 良好(2014年12月22日)
	 * @param instanceOfAttributes
	 */
	public void attributes(Attributes instanceOfAttributes){
		this.attributes=instanceOfAttributes;
	}
	/**
	 * 画像群を応答する。
	 * 良好、不使用(2014年12月22日)
	 * @return this.images
	 */
	public ArrayList<BufferedImage> images(){
		return this.images;
	}
	/**
	 * 画像またはサムネイル画像の文字列を受け取って当該画像を応答する。
	 * 良好(2014年12月22日)
	 * 不使用(2014年12月22日)
	 * @param aString
	 * @return aImage
	 */
	@SuppressWarnings("unused")
	private BufferedImage picture(String aString){
		BufferedImage aImage;
		aImage=images.get(Integer.parseInt(aString));
		return aImage;
	}
	/**
	 * サムネイル画像群を応答する。
	 * 良好(2014年12月22日)
	 * @return this.thumbnails
	 */
	public ArrayList<BufferedImage> thumbnails(){
		return this.thumbnails;
	}
	/**
	 * 自分自身を文字列にして、それを応答する。
	 * 良好(2014年12月22日)
	 * @Override Object
	 * @return super.toString()
	 */
	public String toString(){
		return super.toString();
	}
	/**
	 * タプル群を応答する。
	 * 良好(2014年12月22日)
	 * @return this.tuples
	 */
	public ArrayList<Tuple> tuples(){
		return this.tuples;
	}
}
