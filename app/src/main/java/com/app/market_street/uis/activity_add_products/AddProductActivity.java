package com.app.market_street.uis.activity_add_products;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.app.market_street.R;
import com.app.market_street.adapter.ImageAdsAdapter;
import com.app.market_street.databinding.ActivityAddProductBinding;
import com.app.market_street.language.Language;
import com.app.market_street.models.AddProductModel;
import com.app.market_street.models.SelectedLocation;
import com.app.market_street.models.UserModel;
import com.app.market_street.preferences.Preferences;
import com.app.market_street.share.Common;
import com.app.market_street.uis.activity_map.MapActivity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {
    private ActivityAddProductBinding binding;
    private String lang;

    private List<String> imagesUriList;
    private final String READ_PERM = Manifest.permission.READ_EXTERNAL_STORAGE;
    private final String write_permission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    private final String camera_permission = Manifest.permission.CAMERA;
    private final int READ_REQ = 1, CAMERA_REQ = 2;
    private double lat = 0.0, lng = 0.0;
    private String address = "";


    private ImageAdsAdapter imageAdsAdapter;
    private boolean isVideoAvailable = false;
    private AddProductModel model;
    private Preferences preferences;
    private UserModel userModel;
    private ActivityResultLauncher<Intent> launcher;


    private SelectedLocation selectedLocation;

    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);
        initView();
    }

    private void initView() {
        model = new AddProductModel();

        imagesUriList = new ArrayList<>();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(this);
        Paper.init(this);
        lang = Paper.book().read("lang", "ar");
        binding.setModel(model);
        binding.setLang(lang);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode()==RESULT_OK&&result.getData()!=null){

                selectedLocation = (SelectedLocation) result.getData().getSerializableExtra("location");
                binding.tvLocation.setText(selectedLocation.getAddress());
                binding.tvLocation.setError(null);
            }
        });

        binding.recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        imageAdsAdapter = new ImageAdsAdapter(imagesUriList, this);
        binding.recView.setAdapter(imageAdsAdapter);






        binding.flUploadImage.setOnClickListener(view -> {
            openSheet();
        });

        binding.flGallery.setOnClickListener(view -> checkReadPermission());

        binding.flCamera.setOnClickListener(view -> checkCameraPermission());

        binding.btnCancel.setOnClickListener(view -> {
            closeSheet();
        });



        binding.lllocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddProductActivity.this, MapActivity.class);
                launcher.launch(intent);
            }
        });

        binding.llBack.setOnClickListener(view -> back());

        binding.btnSend.setOnClickListener(view -> checkDataValid());


    }












    public void back() {
        finish();
    }

    public void openSheet() {
        binding.expandLayout.setExpanded(true, true);
    }

    public void closeSheet() {
        binding.expandLayout.collapse(true);

    }


    public void checkDataValid() {
        model.setImagesList(imagesUriList);
        if (model.isDataValid(this)) {
           // getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);



        }
    }





    private List<MultipartBody.Part> getMultipartImage() {
        List<MultipartBody.Part> parts = new ArrayList<>();
        for (String path : imagesUriList) {
            Uri uri = Uri.parse(path);
            MultipartBody.Part part = Common.getMultiPartImage(this, uri, "images[]");
            parts.add(part);
        }
        return parts;
    }

    public void checkReadPermission() {
        closeSheet();
        if (ActivityCompat.checkSelfPermission(this, READ_PERM) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{READ_PERM}, READ_REQ);
        } else {
            SelectImage(READ_REQ);
        }
    }




    public void checkCameraPermission() {

        closeSheet();

        if (ContextCompat.checkSelfPermission(this, write_permission) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, camera_permission) == PackageManager.PERMISSION_GRANTED
        ) {
            SelectImage(CAMERA_REQ);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{camera_permission, write_permission}, CAMERA_REQ);
        }
    }

    private void SelectImage(int req) {

        Intent intent = new Intent();

        if (req == READ_REQ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            } else {
                intent.setAction(Intent.ACTION_GET_CONTENT);

            }

            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setType("image/*");
            startActivityForResult(intent, req);

        } else if (req == CAMERA_REQ) {
            try {
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, req);
            } catch (SecurityException e) {
                Toast.makeText(this, R.string.perm_image_denied, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, R.string.perm_image_denied, Toast.LENGTH_SHORT).show();

            }


        }
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
       if (requestCode == READ_REQ) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                SelectImage(requestCode);
            } else {
                Toast.makeText(this, getString(R.string.perm_image_denied), Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == CAMERA_REQ) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                SelectImage(requestCode);
            } else {
                Toast.makeText(this, getString(R.string.perm_image_denied), Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == READ_REQ && resultCode == Activity.RESULT_OK && data != null) {

            Uri uri = data.getData();
                imagesUriList.add(uri.toString());
                imageAdsAdapter.notifyItemInserted(imagesUriList.size() - 1);

        } else if (requestCode == CAMERA_REQ && resultCode == Activity.RESULT_OK && data != null) {

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            Uri uri = getUriFromBitmap(bitmap);
            if (uri != null) {
                    imagesUriList.add(uri.toString());
                    imageAdsAdapter.notifyItemInserted(imagesUriList.size() - 1);


            }


        }

    }
    private Uri getUriFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        return Uri.parse(MediaStore.Images.Media.insertImage(this.getContentResolver(), bitmap, "", ""));
    }











    public void deleteImage(int adapterPosition) {
        if (imagesUriList.size() > 0) {
            imagesUriList.remove(adapterPosition);
            imageAdsAdapter.notifyItemRemoved(adapterPosition);

        }
    }



}