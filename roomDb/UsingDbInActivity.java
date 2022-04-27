db = Room.databaseBuilder(getApplicationContext(), OurDatabase.class, "DbName")
                //.allowMainThreadQueries()
                .build();
ourDao = db.ourDao();

OurModel ourModelObject = new OurModel();
placeDao.insert(ourModelObject)
                .subscribeOn(Schedulers.io())//io thread
                .observeOn(AndroidSchedulers.mainThread())//changes will be observed at main thread UI thread
                .subscribe(MapsActivity.this::handleResponse)//handleResponse() function which is inside MapsActivity.java will run after insert method finished.
