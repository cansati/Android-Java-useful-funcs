public class SomeActivity {

    private ActivitySomeBinding binding;
  // COPY BELOW
    ActivityResultLauncher<String> permissionLauncher;
  // COPY ABOVE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      // COPY BELOW
        registerLauncher();
      // COPY ABOVE

    }

    
    public void someFunc() {
      // COPY BELOW
        if(ContextCompat.checkSelfPermission(SomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MapsActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)){
                Snackbar.make(binding.getRoot(),"Permission Needed!",Snackbar.LENGTH_INDEFINITE).setAction("Give Permission", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
                    }
                }).show();
            }else{
                permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            }
        }else{
            // Permission Granted, do what you wanna do
        }
      // COPY ABOVE
    }

  // COPY BELOW
    private void registerLauncher() {
        permissionLauncher = this.registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            @Override
            public void onActivityResult(Boolean result) {
                if (result) {
                    if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        // Permission Granted, do what you wanna do
                    }

                }
                else {
                    Toast.makeText(MapsActivity.this, "Permission denied",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
  // COPY ABOVE
}
