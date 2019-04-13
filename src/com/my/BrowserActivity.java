package com.my;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class BrowserActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	Button go,back,fwd,rld;
	WebView wv;
	EditText et;
	@Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    go=(Button)findViewById(R.id.go);
    back=(Button)findViewById(R.id.back);
    fwd=(Button)findViewById(R.id.fwd);
    rld=(Button)findViewById(R.id.rld);
    et=(EditText)findViewById(R.id.editText1);
    wv=(WebView)findViewById(R.id.webView1);
    go.setOnClickListener(this);
    back.setOnClickListener(this);
    fwd.setOnClickListener(this);
    rld.setOnClickListener(this);
    
    
    wv.setWebViewClient(new myClient());
    wv.getSettings().setJavaScriptEnabled(true);
    wv.getSettings().setLoadsImagesAutomatically(true);
    wv.getSettings().setLoadWithOverviewMode(true);
    
    
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch (v.getId())
		{
		case R.id.go:
		String url = et.getText().toString();
		wv.loadUrl(url);
			break;
			
		case R.id.back:
			if(wv.canGoBack())
			{
				wv.goBack();
			}
			break;
		
		case R.id.fwd:
			if(wv.canGoForward())
			{
				wv.goForward();
			}
			break;
			
		case R.id.rld:
			wv.reload();
			break;	
		}
		
	}
}