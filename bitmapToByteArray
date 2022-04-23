public byte[] bitmapToByteArray(Bitmap imageBitmap){
  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  imageBitmap.compress(Bitmap.CompressFormat.PNG, /*quality 0-100*/ 50, outputStream);
  byte[] byteArray = outputStream.toByteArray();
  return byteArray;
}
