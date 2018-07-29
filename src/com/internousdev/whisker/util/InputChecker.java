package com.internousdev.whisker.util;

public class InputChecker {

	public static boolean length(String value, int min, int max){
		if (value == null) return false;
		return min <= value.length() && value.length() <= max;
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
