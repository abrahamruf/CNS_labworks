import java.io.*;
public class columnarmain
{
char Arr[][],encryption[][],decryption[][],keyA[],keytmp[];
public void crtmtxE(String s,String key,int row,int column)
{
Arr=new char[row][column];
int k=0;
keyA=key.toCharArray();
for(int i=0;i<row;i++)
{
for(int j=0;j<column;j++)
{
if(k<s.length())
{
Arr[i][j]=s.charAt(k);
k++;
}
else
{
Arr[i][j]=' ';
}
}
}
}
public void createkey(String key,int column)
{
keytmp=key.toCharArray();
for(int i=0;i<column-1;i++)
{
for(int j=i+1;j<column;j++)
{
if(keytmp[i]>keytmp[j])
{
char temp=keytmp[i];
keytmp[i]=keytmp[j];
keytmp[j]=temp;
}
}
}
}
public void crtmtxD(String s,String key,int row,int column)
{
Arr=new char[row][column];
int k=0;
keyA=key.toCharArray();
for(int i=0;i<column;i++)
{
for(int j=0;j<row;j++)
{
if(k<s.length())
{
Arr[j][i]=s.charAt(k);
k++;
}
else
{
Arr[j][i]=' ';
}
}
}
}
public void encryption(int row,int column)
{
encryption=new char[row][column];
for(int i=0;i<column;i++)
{
for(int j=0;j<column;j++)
{
if(keyA[i]==keytmp[j])
{
for(int k=0;k<row;k++)
{
encryption[k][j]=Arr[k][i];
}
keytmp[j]='?';
break;
}
}
}
}
public void decryption(int row,int column)
{
decryption=new char[row][column];
for(int i=0;i<column;i++)
{
for(int j=0;j<column;j++)
{
if(keyA[j]==keytmp[i])
{
for(int k=0;k<row;k++)
{
decryption[k][j]=Arr[k][i];
}
keyA[j]='?';
break;
}
}
}
}
public void resultE(int row,int column,char Arr[][])
{
System.out.println("Result:");
for(int i=0;i<column;i++)
{
for(int j=0;j<row;j++)
{
System.out.print(Arr[j][i]);
}
}
}
public void resultD(int row,int column,char Arr[][])
{
System.out.println("Result:");
for(int i=0;i<row;i++)
{
for(int j=0;j<column;j++)
{
System.out.print(Arr[i][j]);
}
}
}
public static void main(String args[])throws IOException
{
int row,column,choice;
columnarmain obj=new columnarmain();
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Menu:\n1) Encryption\n2) Decryption");
choice=Integer.parseInt(in.readLine());
System.out.println("Enter the string:");
String s=in.readLine();
System.out.println("Enter the key:");
String key=in.readLine();
row=s.length()/key.length();
if(s.length()%key.length()!=0)
row++;
column=key.length();
switch(choice)
{
case 1: obj.crtmtxE(s,key,row,column);
obj.createkey(key,column);
obj.encryption(row,column);
obj.resultE(row,column,obj.encryption);
break;
case 2: obj.crtmtxD(s,key,row,column);
obj.createkey(key,column);
obj.decryption(row,column);
obj.resultD(row,column,obj.decryption);
break;
}
}
}





