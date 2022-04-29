// CHECK FİREBASE OFFICIAL DOCS FOR MORE ACCURATE RESULT

public class UploadActivity extends AppCompatActivity {
  // COPY BELOW
    private FirebaseStorage firebaseStorage;
    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;
  // COPY ABOVE
    private ActivityUploadBinding binding;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
      // COPY BELOW
        firebaseStorage = FirebaseStorage.getInstance();
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        storageReference = firebaseStorage.getReference();
      // COPY ABOVE
    }
  // COPY BELOW
    public void uploadButtonClicked(View view){
        if(imageUri!=null){
            UUID uuid = UUID.randomUUID(); // generating universal unique image name.
            String imageFirebaseUrl = "type_image_url_here/" + uuid + ".jpg";
            storageReference.child(imageFirebaseUrl).putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //Download url
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UploadActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
  // COPY ABOVE
}
