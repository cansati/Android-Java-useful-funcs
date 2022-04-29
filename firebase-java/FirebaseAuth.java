// CHECK FİREBASE DOCS FOR MORE ACCURATE RESULTS
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
  // COPY BELOW
    private FirebaseAuth mAuth;
  // COPY ABOVE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // COPY BELOW
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        
        // Checking is there any logged in user
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!=null){
            Intent intent = new Intent(MainActivity.this, FeedActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }
      // COPY ABOVE
    }
  // COPY BELOW
    public void signInClicked(View view){
        String email = binding.edtEmail.getText().toString();
        String password = binding.edtPassword.getText().toString();
        if(email.equals("") || password.equals("")){
            Toast.makeText(this,"Email or password can not be empty",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this, FeedActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void signUpClicked(View view){
        String email = binding.edtEmail.getText().toString();
        String password = binding.edtPassword.getText().toString();
        if(email.equals("") || password.equals("")){
            Toast.makeText(this,"Email or password can not be empty",Toast.LENGTH_SHORT).show();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this, FeedActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
  // COPY ABOVE
}
