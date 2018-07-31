package com.internousdev.whisker.util;

public class InputChecker {

	public static boolean length(String value, int min, int max){
		if (value == null) return false;
		return min <= value.length() && value.length() <= max;
	}

	public static boolean regex(String value, RegexDesc desc){

		if (value == null) return false;
		if (!desc.is()) return false;

		String regex = "";

		regex += "^[";

		if (desc.isHalfNumber()) regex += "0-9";
		if (desc.isFullNumber()) regex += "０-９";
		if (desc.isHalfAlphabet()) regex += "a-z";
		if (desc.isFullAlphabet()) regex += "A-Z";
		if (desc.isHiragana()) regex += "ぁ-ん";
		if (desc.isKatakana()) regex += "ァ-ヺ";
		if (desc.isKanji()) regex += "一-龯";
		if (desc.isHalfSymbol()) regex += "@.,;:!#$%&'*+-/=?^_`{|}~";
		if (desc.isFullSymbol()) regex += "＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
		if (desc.isHalfSpace()) regex += " ";
		if (desc.isFullSpace()) regex += "　";
		if (desc.getCustom() != null){
			regex += desc.getCustom();
		}

		regex += "]+$";

		return value.matches(regex);
	}

	public static String htmlEscape(String text) {

        StringBuffer sb=new StringBuffer();
        for(int i=0;i<text.length();i++){
            switch(text.charAt(i)){
                //HTMLタグの無効化（&"<>）
                case '&' :
                    sb.append("&amp;");
                    break;
                case '<' :
                    sb.append("&lt;");
                    break;
                case '>' :
                    sb.append("&gt;");
                    break;
                case '"' :
                    sb.append("&quot;");
                    break;
                case '\\' :
                    sb.append("&yen;");
                    break;
                //スペースの変換（半角スペース → &nbsp;）
                case ' ' :
                    sb.append("&nbsp;");
                    break;
                //タブの変換（\t → &nbsp;&nbsp;&nbsp;&nbsp;）
                case '\t' :
                    sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
                    break;
                default :
                    sb.append(text.charAt(i));
                break;
            }
        }
        //改行コードの変換（\r\n,\r,\n → <br>）
        return sb.toString().replaceAll("(\r\n|\r|\n)", "<br/>");
    }
}
