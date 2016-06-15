package com.uses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.example.androidcaches.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Mytestlrucache extends Activity{
	//使用lruCache
	private ListView list;
	private ArrayAdapter<String> adapter;
	private List<String> listdata;
	private LruCache<Integer,String> mycache = new LruCache<Integer,String>(4);//缓存。
	public Mytestlrucache() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//添加显示的视图。
		//控制cache的运转。
		setContentView(R.layout.testcache);
		Button btn = (Button)findViewById(R.id.button1);
		list = (ListView)findViewById(R.id.list1);
		listdata = new LinkedList<String>();
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listdata);
			
		list.setAdapter(adapter);
		btn.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("hello");
				System.out.println("hello");
				System.out.println("hello");
				for(int i=0;i<10;i++)
				{
					mycache.put(i, "id"+i);//添加
				}
				Set<Map.Entry<Integer,String>> set = mycache.snapshot().entrySet();
				listdata.clear();
				for(Entry<Integer,String> k : set)
				{
					//System.out.println(k.getKey()+k.getValue()+"");//遍历缓存中现有的元素。注意遍历的顺序。
					listdata.add(k.getKey()+k.getValue()+"");
				}
				adapter.notifyDataSetChanged();//提示数据改变。
			}
		});
	}


	public static void display(LruCache<Integer,String> temp)
	{
		//
		
	}
}
