public class MainActivity extends AppCompatActivity {
  
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
  
    ...
      
      //Example usage
      compositeDisposable.add(placeDao.insert(place)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(MapsActivity.this::handleResponse));
  
    ...
  
    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
