public Bitmap byteArrayToBitmap(byte[] bytes){
  
  Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
  return bitmap;
  
}
