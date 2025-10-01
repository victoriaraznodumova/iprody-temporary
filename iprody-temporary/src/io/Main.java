package io;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
//        File file = new File("out/some3.txt");
//        file.createNewFile();

        File file = new File("src/io/files/some.txt");
        file.createNewFile();
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());


        File file1 = new File("src");
        System.out.println(file1.exists());

        System.out.println();
        System.out.println(Arrays.toString(file1.list()));
        System.out.println(Arrays.toString(file1.listFiles()));

        System.out.println();
        File directoryToCreate = new File("new/next");
        System.out.println(directoryToCreate.mkdirs());
        System.out.println(directoryToCreate.getAbsolutePath());
        System.out.println(directoryToCreate.getAbsoluteFile());
        System.out.println(directoryToCreate.getCanonicalPath());
        System.out.println();


        InputStream inputStream = System.in;
//        Scanner sc = new Scanner(System.in);
//        int read = inputStream.read();
//        byte[] byteToRead = new byte[200];
//        while ( inputStream.read(byteToRead) != -1){
//        }
        System.out.println();
        inputStream.close();

        OutputStream outputStream;



        String someData = "hello world on some different languages with some text if you want read this";
        byte[] bytes = someData.getBytes();
        inputStream = new ByteArrayInputStream(bytes);


        //пример стандартной работы со стримами без синтаксического сахара, менее желателен
        inputStream = null;
        try {
            inputStream = new ByteArrayInputStream(bytes);
        }
        finally{
            if (inputStream != null)
                inputStream.close();
        }

        byte[] buffer = new byte[50];

        //способ работы со стримами с применением синтаксического сахара
        System.out.println("Поток ввода");
        try (InputStream inputStream1 = new ByteArrayInputStream(bytes)){
            while (inputStream1.read(buffer) > 0) {
                System.out.println(new String(buffer));
                System.out.println(Arrays.toString(buffer));
                buffer = new byte[50];
            }
        }

        System.out.println("\nПоток вывода");
        try (OutputStream outputStream1 = new ByteArrayOutputStream(100)){
            //записываем в поток вывода на основе источника - массива байт
            outputStream1.write(bytes);
            System.out.println(outputStream1);
        }



        System.out.println("\nFileInputStream");
        byte[] newBuffer = new byte[50];
        try (FileInputStream fileInputStream = new FileInputStream("src/io/files/some.txt")){
            while (fileInputStream.read(newBuffer) > 0){
                System.out.println(new String(newBuffer));
                newBuffer = new byte[50];
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        //ЕСЛИ ФАЙЛ БЫЛ УДАЛЕН И СОЗДАЛСЯ ТОЛЬКО ПРИ ВЫПОЛНЕНИИ ПРОГРАММЫ, ТО ОН БУДЕТ ПУСТЫМ И НИЧЕГО НЕ СЧИТАЕТСЯ
        //ПОСЛЕ ПЕРВОГО ЗАПУСКА В НЕГО ЗАПИШЕТСЯ ТЕКСТ ИЗ СТРОК НИЖЕ И ОН ВПОСЛЕДСТВИИ БУДЕТ СЧИТЫВАТЬСЯ, ПОКА ЕГО НЕ УДАЛИТЬ



        //пробовали копировать данные из одного файла в другой
//        System.out.println("\nFileInputStream");
//        byte[] newBuffer = new byte[1024];
//        try (FileInputStream fileInputStream = new FileInputStream("src/io/files/some.txt")){
//            FileOutputStream fileOutputStream = new FileOutputStream("src/io/files/newSome.txt");
//            int bytesRead;
//            while ((bytesRead = fileInputStream.read(newBuffer)) > 0){
//                fileOutputStream.write(newBuffer, 0, bytesRead);
//            }
//            fileOutputStream.close();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }



        System.out.println("\nFileOutputStream");
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/io/files/some.txt")){
//            fileOutputStream.write(bytes, 6, 5);
            fileOutputStream.write(bytes);
        }
        catch (IOException e){
            e.printStackTrace();
        }


        String ex = "example";
        char[] chars = ex.toCharArray();
        System.out.println(Arrays.toString(chars));
        byte[] byteArr = ex.getBytes();
        System.out.println(Arrays.toString(byteArr));
        String s = new String(byteArr);
        System.out.println(s);

        String line = "I am a java developer";
        String[] words = line.split(" ");
        String[] twoWords = line.split(" ", 3);
        System.out.println("\n" + Arrays.toString(twoWords));



        //Buffered
        try (var bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/io/files/some.txt"))){
            bufferedOutputStream.write(bytes);
        }
        catch (IOException e){
            e.printStackTrace();
        }


        //Data
        try (var dataOutputStream = new DataOutputStream(new FileOutputStream("src/io/files/some.txt"))){
            for(int i = 0; i < 200; i++)
                dataOutputStream.writeInt(i);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try (var dataInputStream = new DataInputStream(new FileInputStream("src/io/files/some.txt"))){
            for(int i = 0; i < 200; i++)
                System.out.println(dataInputStream.readInt());
        }
        catch (IOException e){
            e.printStackTrace();
        }




        //начинается сериализация
//        Person person = new Person(1, "Ivan Sidorov");
//        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/io/files/person.txt"))){
//            objectOutputStream.writeObject(person);
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//        try (var objectInputStream = new ObjectInputStream(new FileInputStream("src/io/files/person.txt"))){
//            Object o = objectInputStream.readObject();
//            System.out.println(o.toString());
//        } catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
        //работало корректно




//        Person person2 = new Person(2, "Peter Sidorov", "some description");
//         try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/io/files/person2.txt"))){
//            objectOutputStream.writeObject(person2);
//        } catch (IOException e){
//             e.printStackTrace();
//        }
//        try (var objectInputStream = new ObjectInputStream(new FileInputStream("src/io/files/person2.txt"))){
//            Object o = objectInputStream.readObject();
//            System.out.println(o.toString());
//        } catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
        //работало корректно




        //про циклические ссылки
//        var book = new Book("title", "author");
//        Person personWithBook = new Person(3, "Peter Sidorov", book);
//        book.setPerson(personWithBook);
//        try (var objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/io/files/personWithBook.txt"))){
//            objectOutputStream.writeObject(personWithBook);
//        } catch (IOException e){
//             e.printStackTrace();
//        }
//        try (var objectInputStream = new ObjectInputStream(new FileInputStream("src/io/files/personWithBook.txt"))){
//            Person o = (Person) objectInputStream.readObject();
//            System.out.println(o.toString());
//            System.out.println(o.getBook().toString());
//        } catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
        //работало корректно



//        try (var writer = new FileWriter("src/io/files/some.txt")){
//            writer.write(someData);
//        } catch (IOException e){
//             e.printStackTrace();
//        }
//        try (var reader = new FileReader("src/io/files/some.txt")){
//            char[] charsBuffer = new char[2048];
//            while (reader.read(charsBuffer) > 0){
//                System.out.println(new String(charsBuffer));
//                charsBuffer = new char[2048];
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        //работало корректно



//        try (var bufferedReader = new BufferedReader(new FileReader("src/io/files/some.txt"))){
//            String readLine = null;
//            while ((readLine = bufferedReader.readLine()) != null){
//                System.out.println(readLine);
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        //работало корректно




//        try (RandomAccessFile raf = new RandomAccessFile("src/io/files/some.txt", "r")){
//            raf.seek(2);
//            System.out.println((char) raf.read());
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
        //работало корректно
    }
}