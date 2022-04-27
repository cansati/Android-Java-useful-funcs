public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        
        //usage => binding.someViewComponent
    }
