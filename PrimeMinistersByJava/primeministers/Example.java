package primeministers;

/**
 * 例題プログラム：総理大臣のCSVファイルをHTMLページへと変換する。
 * 良好(2014年12月22日)
 */
public class Example extends Object
{
	/**
	 * メインプログラム。
	 * 良好(2014年12月22日)
	 */
	public static void main(String[] arguments)
	{
		// トランスレータのインスタンスを生成する。
		Translator aTranslator = new Translator();

		// トランスレータに総理大臣のCSVファイルをHTMLページへ変換するように依頼する。
		aTranslator.perform();

		return;
	}
}
