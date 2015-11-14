package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DataService {
	HashMap<Integer,Memo> memoMap = new HashMap<Integer,Memo>();
	public void addMemo(Memo memo){
		memoMap.put(memo.number, memo);
	}
	public void deleteMemo(int number){
		memoMap.remove(number);
	}
}
