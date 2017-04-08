package com.example.saucecode.thegoviya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.microsoft.windowsazure.mobileservices.*;

public class AzureConnectSample extends AppCompatActivity {
    private MobileServiceClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azure_connect_sample);
        mClient = new MobileServiceClient(
                "https://thegoviya.azurewebsites.net",
                this
        );

        TodoItem item = new TodoItem();
        item.Text = "Awesome item";
        mClient.getTable(TodoItem.class).insert(item, new TableOperationCallback<item>() {
            public void onCompleted(TodoItem entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    // Insert succeeded
                } else {
                    // Insert failed
                }
            }
        });

    }

}
