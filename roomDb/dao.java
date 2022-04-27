@Dao
public interface OurDao {

    //Completable is a rxjava3 object
    @Insert
    Completable insert(OurModel ourModel);

    @Delete
    Completable delete(OurModel ourModel);
    
    //Flowable is a rxjava3 object
    @Query("SELECT * FROM OurModel")
    Flowable<List<OurModel>> getAll();
}
