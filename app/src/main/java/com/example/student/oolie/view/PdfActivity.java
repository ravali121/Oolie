package com.example.student.oolie.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.student.oolie.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class PdfActivity extends Activity implements OnPageChangeListener,OnLoadCompleteListener {
    private static final String TAG = PdfActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "Oolie Rules of the Road.pdf";
    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    Button buttonAgree, buttonDontAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        buttonAgree = (Button)findViewById(R.id.buttonAgree);
        buttonDontAgree=(Button)findViewById(R.id.buttonDontAgree);


        buttonAgree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent homefeedActivity = new Intent(PdfActivity.this, HomefeedActivity.class);
                startActivity(homefeedActivity);
                finish();
            }
        });
        buttonDontAgree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent loginActivity = new Intent(PdfActivity.this, LoginActivity.class);
                startActivity(loginActivity);
                finish();
            }
        });

        pdfView= (PDFView)findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);
    }


    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");

    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
}