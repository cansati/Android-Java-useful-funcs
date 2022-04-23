public Bitmap produceSmallerImageBitmapByAmountOfPixel(Bitmap image, int maxAmountOfPixel){
        //2nd parameter is width x height
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        float imageRatio = (float) imageWidth / (float) imageHeight;
        int x = (int) Math.round(Math.sqrt(Math.round(imageRatio * maxAmountOfPixel)));
        int y = (int) Math.round(Math.sqrt(Math.round(maxAmountOfPixel / imageRatio)));
        return selectedImageBitmap.createScaledBitmap(image,x,y,true);
    }
