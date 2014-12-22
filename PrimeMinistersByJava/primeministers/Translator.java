package primeministers;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * トランスレータ：総理大臣のCSVファイルをHTMLページへと変換するプログラム。
 * 良好(2014年12月22日)
 */
public class Translator extends Object
{
	/**
	 * CSVに由来するテーブルを記憶するフィールド。
	 * 良好(2014年12月22日)
	 */
	private Table inputTable;
	/**
	 * HTMLに由来するテーブルを記憶するフィールド。
	 * 良好(2014年12月22日)
	 */
	private Table outputTable;

	/**
	 * トランスレータのコンストラクタ。
	 * 良好(2014年12月22日)
	 */
	public Translator(){
		super();
		return;
	}
	/**
	 * 在位日数を計算して、それを文字列にして応答する。
	 * 良好(2014年12月22日)
	 * @param periodString
	 * @return dayString
	 */
	public String computeNumberOfDays(String periodString){
		ArrayList<String> splitPeriod = IO.splitString(periodString,"[〜年月日]+");
		long endDay;
		Calendar startDays = Calendar.getInstance();
		Calendar endDays = Calendar.getInstance();
		startDays.set(Integer.parseInt(splitPeriod.get(0)),Integer.parseInt(splitPeriod.get(1)),Integer.parseInt(splitPeriod.get(2)));		
		long startDay=startDays.getTimeInMillis();
		if(splitPeriod.size()<4){
			Calendar nowDate = Calendar.getInstance();
			endDay = nowDate.getTimeInMillis();
		}else{
			endDays.set(Integer.parseInt(splitPeriod.get(3)),Integer.parseInt(splitPeriod.get(4)),Integer.parseInt(splitPeriod.get(5)));
			endDay=endDays.getTimeInMillis();
		}
		long changeTime = 1000*60*60*24;
		long differenceDays = (endDay - startDay) / changeTime;
		String dayString = Integer.toString((int)differenceDays);
		return dayString;
	}
	/**
	 * サムネイル画像から画像へ飛ぶためのHTML文字列を作成して、それを応答する。
	 * 良好(2014年12月22日)
	 * @param aString
	 * @param aTuple
	 * @param no
	 * @return resultString
	 */
	public String computeStringOfImage(String aString,Tuple aTuple,int no){
		ArrayList<String> values = aTuple.values();
		
		String image=values.get(aTuple.attributes().indexOfImage());
		String thumbnail=aString;
		ArrayList<String> imageLink = IO.splitString(image,"/");
		
		String resultString = "<a name=\""+no+"\" href="+image+"><img class=\"borderless\" src=\""+thumbnail+"\" width=\"25\" height=\"32\" alt=\""+imageLink.get(1)+"\"></a>";
		return resultString;
	}
	/**
	 * 総理大臣のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。
	 * 良好(2014年12月22日)
	 * @param aTable
	 * @return resultTable;
	 */
	public Table table(Table aTable){
		Table resultTable = new Table();
		Attributes instanceOfAttributes = new Attributes("output");
		resultTable.attributes(instanceOfAttributes);
		for(Tuple aTuple : aTable.tuples()){
			ArrayList<String> tranceList = new ArrayList<String>();
			ArrayList<String> values = aTuple.values();
			Attributes attributes =aTuple.attributes();
			tranceList.add(values.get(attributes.indexOfNo()));
			tranceList.add(values.get(attributes.indexOfOrder()));
			tranceList.add(values.get(attributes.indexOfName()));
			tranceList.add(values.get(attributes.indexOfKana()));
			tranceList.add(values.get(attributes.indexOfPeriod()));
			tranceList.add(this.computeNumberOfDays(values.get(attributes.indexOfPeriod())));
			tranceList.add(values.get(attributes.indexOfSchool()));
			tranceList.add(values.get(attributes.indexOfParty()));
			tranceList.add(values.get(attributes.indexOfPlace()));
			tranceList.add(this.computeStringOfImage(values.get(attributes.indexOfThumbnail()), aTuple,Integer.parseInt(values.get(attributes.indexOfNo()))));
			Tuple tranceTuple = new Tuple(resultTable.attributes(),tranceList);
			resultTable.add(tranceTuple);
		}
		return resultTable;
	}
	/**
	 * 総理大臣のCSVファイルをHTMLページへ変換する。
	 * 良好(2014年12月22日)
	 */
	public void perform()
	{
		Downloader aDownloader = new Downloader();
		Writer aWriter = new Writer();
		this.inputTable=aDownloader.table();
		this.outputTable=this.table(inputTable);
		aWriter.table(outputTable);
		String aString = "総理大臣のCSVファイルからHTMLページへの変換を無事に完了しました。\n";
		JOptionPane.showMessageDialog(null, aString, "報告", JOptionPane.PLAIN_MESSAGE);
		return;
	}
}
