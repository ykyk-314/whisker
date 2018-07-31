package com.internousdev.whisker.util;

public class RegexDesc {

	private boolean halfNumber = false;		// 半角数字
	private boolean fullNumber = false;		// 全角数字
	private boolean halfAlphabet = false;	// 半角英字
	private boolean fullAlphabet = false;	// 全角英字
	private boolean hiragana = false;		// ひらがな
	private boolean katakana = false;		// カタカナ
	private boolean kanji = false;			// 漢字
	private boolean halfSymbol = false;		// 半角記号
	private boolean fullSymbol = false;		// 全角記号
	private boolean halfSpace = false;		// 半角スペース
	private boolean fullSpace = false;		// 全角スペース
	private String custom = null;			// カスタム

	public RegexDesc(){

	}

	public RegexDesc(boolean halfNumber, boolean fullNumber, boolean halfAlphabet, boolean fullAlphabet, boolean hiragana, boolean katakana, boolean kanji, boolean halfSymbol, boolean fullSymbol, boolean halfSpace, boolean fullSpace, String custom){
		this.halfNumber = halfNumber;
		this.fullNumber = fullNumber;
		this.halfAlphabet = halfAlphabet;
		this.fullAlphabet = fullAlphabet;
		this.hiragana = hiragana;
		this.katakana = katakana;
		this.kanji = kanji;
		this.halfSymbol = halfSymbol;
		this.fullSymbol = fullSymbol;
		this.halfSpace = halfSpace;
		this.fullSpace = fullSpace;
		this.custom = custom;
	}

	public boolean isHalfNumber() {
		return halfNumber;
	}
	public void setHalfNumber(boolean halfNumber) {
		this.halfNumber = halfNumber;
	}
	public boolean isFullNumber() {
		return fullNumber;
	}
	public void setFullNumber(boolean fullNumber) {
		this.fullNumber = fullNumber;
	}
	public boolean isHalfAlphabet() {
		return halfAlphabet;
	}
	public void setHalfAlphabet(boolean halfAlphabet) {
		this.halfAlphabet = halfAlphabet;
	}
	public boolean isFullAlphabet() {
		return fullAlphabet;
	}
	public void setFullAlphabet(boolean fullAlphabet) {
		this.fullAlphabet = fullAlphabet;
	}
	public boolean isHiragana() {
		return hiragana;
	}
	public void setHiragana(boolean hiragana) {
		this.hiragana = hiragana;
	}
	public boolean isKatakana() {
		return katakana;
	}
	public void setKatakana(boolean katakana) {
		this.katakana = katakana;
	}
	public boolean isKanji() {
		return kanji;
	}
	public void setKanji(boolean kanji) {
		this.kanji = kanji;
	}
	public boolean isHalfSymbol() {
		return halfSymbol;
	}
	public void setHalfSymbol(boolean halfSymbol) {
		this.halfSymbol = halfSymbol;
	}
	public boolean isFullSymbol() {
		return fullSymbol;
	}
	public void setFullSymbol(boolean fullSymbol) {
		this.fullSymbol = fullSymbol;
	}
	public boolean isHalfSpace() {
		return halfSpace;
	}
	public void setHalfSpace(boolean halfSpace) {
		this.halfSpace = halfSpace;
	}
	public boolean isFullSpace() {
		return fullSpace;
	}
	public void setFullSpace(boolean fullSpace) {
		this.fullSpace = fullSpace;
	}
	public String getCustom() {
		return custom;
	}
	public void setCustom(String custom) {
		this.custom = custom;
	}

	public void setFlagAll(boolean flag){
		halfNumber = flag;
		fullNumber = flag;
		halfAlphabet = flag;
		fullAlphabet = flag;
		hiragana = flag;
		katakana = flag;
		kanji = flag;
		halfSymbol = flag;
		fullSymbol = flag;
		halfSpace = flag;
		fullSpace = flag;
	}

	public boolean is(){
		return
			halfNumber ||
			fullNumber ||
			halfAlphabet ||
			fullAlphabet ||
			hiragana ||
			katakana ||
			kanji ||
			halfSymbol ||
			fullSymbol ||
			halfSpace ||
			fullSpace ||
			custom != null;
	}

	public static final String LOGIN_ID = "loginId";
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String CUSTOM1 = "custom1";

	public static RegexDesc format(String format) throws Exception{

		RegexDesc regex = new RegexDesc();

		switch (format){
		case LOGIN_ID:
		case PASSWORD:
			// 半角英数字
			regex.setHalfNumber(true);
			regex.setHalfAlphabet(true);
			break;
		case NAME:
			// 半角全角英数字ひらがなカタカナ漢字
			regex.setHalfNumber(true);
			regex.setFullNumber(true);
			regex.setHalfAlphabet(true);
			regex.setFullAlphabet(true);
			regex.setHiragana(true);
			regex.setKatakana(true);
			regex.setKanji(true);
			break;
		case CUSTOM1:
			regex.setFlagAll(true);
			regex.setCustom("\r\n");
			break;
		default:
			regex = null;
			break;
		}

		if (regex == null){
			System.out.println("RegexDesc: error");
			throw new Exception();
		}

		return regex;
	}
}
