import java.io.*;
import java.util.*;

class PackUnpack
{
    public static void main(String Arg[])
    {
        File Fobj = null, FobjX = null, Packobj = null, fobj = null;
        int FileSize = 0, iReturn = 0, iCnt = 0, iInput = 0;
        FileOutputStream fopackobj = null, FOobj = null;
        String DirName = "", PackName = "", Header = "";
        FileInputStream fiobj = null, FIobj = null;
        String Packname = null, SHeader = null;
        int i = 0, j = 0,iRet = 0, iCount = 0;
        boolean bret = false;
        Scanner sobj = null;   

        sobj = new Scanner(System.in);

        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("------------------ File Packer Unpacker CUI Module ------------------");
        System.out.println("---------------------------------------------------------------------");

        System.out.println("\nSelect what you want to do : ");
        System.out.println("1. Packing");
        System.out.println("2. UnPacking");
        System.out.println("Enter Your choice : ");
        iInput = sobj.nextInt();

        if(iInput == 1)
        {
            try
            {
                sobj = new Scanner(System.in);
                byte Buffer[] = new byte[1024];

                System.out.println("-------------------------- Packing Activity -------------------------\n");

                System.out.println("Enter the name of directory/folder that you want to open for packing : ");
                DirName = sobj.nextLine();

                System.out.println("Enter the name of packed file that you want to create : ");
                PackName = sobj.nextLine();
                
                Packobj = new File(PackName);
                bret = Packobj.createNewFile();

                if(bret == true)
                {
                    System.out.println("\nPacked file gets succesfully created with the name : "+PackName);
                }
                else
                {
                    System.out.println("Unable to proceed as pack file is not created");
                    return;
                }

                fopackobj = new FileOutputStream(Packobj);

                fobj = new File(DirName);

                if(fobj.exists())
                {
                    System.out.println("\nDirectory/folder is succesfully opened for the packing activity\n");

                    File Arr[] = fobj.listFiles();

                    for(i = 0; i < Arr.length; i++)
                    {
                        if((Arr[i].getName()).endsWith(".txt"))
                        {
                            Header = Arr[i].getName()+" "+Arr[i].length();
                            
                            for(j = Header.length(); j < 100; j++)
                            {
                                Header = Header + " ";
                            }

                            fopackobj.write(Header.getBytes(),0,100);

                            fiobj = new FileInputStream(Arr[i]);

                            while((iRet = fiobj.read(Buffer)) != -1)
                            {
                                fopackobj.write(Buffer,0,iRet);
                            }

                            fiobj.close();
                            Header = "";
                            iCount++;
                        }
                    }
                    System.out.println("Total number of files scanned from the Directory/folder are : "+Arr.length);
                    System.out.println("Total number of files packed : "+iCount);
                    
                    fiobj.close();
                    fopackobj.close();
                }
                else
                {
                    System.out.println("There is no such directory/folder!\n");
                }
                System.out.println("\n---------------------------------------------------------------------");
                System.out.println("--------- Thank you for using File Packer-Unpacker ------------");
                System.out.println("---------------------------------------------------------------------");
            } // End of try
            catch(Exception eobj)
            {
                System.out.println("Exception occured : "+eobj);
            }
        }
        else if(iInput == 2)
        {
            try
            {
                sobj = new Scanner(System.in);
                
                System.out.println("\n------------------------ Unpacking Activity -------------------------\n");

                System.out.println("Enter the name of packed file that you want to unpack : ");
                Packname = sobj.nextLine();
                
                Fobj = new File(Packname);

                if(Fobj.exists())
                {
                    FIobj = new FileInputStream(Fobj);

                    byte Headers[] = new byte[100];

                    while((iReturn =FIobj.read(Headers)) != -1)
                    {
                        SHeader = new String(Headers);
                        SHeader = SHeader.trim();
                        String Arr[] = SHeader.split(" ");

                        FobjX = new File(Arr[0]);
                        FobjX.createNewFile();

                        System.out.println("File extracted with name : "+Arr[0]);
                        
                        FOobj = new FileOutputStream(FobjX);

                        FileSize = Integer.parseInt(Arr[1]);
                        byte Buffer[] = new byte[FileSize];

                        FIobj.read(Buffer);
                        FOobj.write(Buffer,0,FileSize);

                        FOobj.close();
                        iCnt++;
                    }
                    FIobj.close();

                    System.out.println("Number of files succesfully extracted : "+iCnt);
                }
                else
                {
                    System.out.println("\nThere is no such packed file!");
                    return;
                }

                System.out.println("\n---------------------------------------------------------------------");
                System.out.println("--------- Thank you for using File Packer-Unpacker ------------");
                System.out.println("---------------------------------------------------------------------");

            } // End of try
            catch(Exception eobj)
            {
                System.out.println("Exception occured : "+eobj);
            }
        }
        else
        {
            System.out.println("\nInvalid Input!");
        } 
    }
}






        