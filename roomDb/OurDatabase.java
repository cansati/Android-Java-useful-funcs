@Database(entities = {OurModel.class}, version = 1)
public abstract class OurDatabase extends RoomDatabase{

    public abstract OurDao ourDao();
}
