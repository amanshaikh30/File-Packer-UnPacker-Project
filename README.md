# File Packer-Unpacker CLI Module

This is a Java-based command-line utility that provides functionality to pack multiple `.txt` files from a directory into a single packed file and unpack them back into individual files. It is particularly useful for archiving and transferring text-based data efficiently.

---

## **Features**
- **Packing**:
  - Scans a directory for `.txt` files.
  - Combines the contents of multiple `.txt` files into a single packed file.
  - Adds metadata (file name and size) for each file as a header.
- **Unpacking**:
  - Extracts individual files from the packed file.
  - Restores the original file names and content.

---

## **Technologies Used**
- Java SE
- Core Java File I/O (`java.io`)
- Command-Line Interface (CLI)

---

## **How It Works**

### **1. Packing**
1. User specifies a directory containing `.txt` files.
2. The program creates a packed file.
3. For each `.txt` file in the directory:
   - A 100-byte header is added containing the file name and size.
   - The file content is appended after the header.
4. Packed file is created for storage or transfer.

### **2. Unpacking**
1. User specifies the packed file to unpack.
2. The program reads the packed file sequentially.
3. For each header:
   - Extracts the file name and size.
   - Writes the corresponding file content to a new file with the extracted name.

---

## **Installation**
1. Clone the repository:
   ```bash
   git clone https://github.com/amanshaikh30/file-packer-unpacker.git
   ```
2. Navigate to the project directory:
   ```bash
   cd file-packer-unpacker
   ```
3. Compile the Java file:
   ```bash
   javac PackUnpack.java
   ```
4. Run the program:
   ```bash
   java PackUnpack
   ```

---

## **Usage**

### **1. Packing**
- Select option `1` for packing.
- Enter the name of the directory containing `.txt` files.
- Enter the name of the packed file to create.
- The program will scan the directory and pack all `.txt` files.

### **2. Unpacking**
- Select option `2` for unpacking.
- Enter the name of the packed file.
- The program will extract the files into the current directory.

---

## **Example**

### **Packing Example**
1. Directory structure:
   ```
   /example_dir
     ├── file1.txt
     ├── file2.txt
   ```
2. Packing these files:
   ```bash
   Enter the name of the directory/folder: example_dir
   Enter the name of the packed file: packed_file.pck
   ```
   Output:
   ```
   Packed file gets successfully created with the name: packed_file.pck
   Total number of files packed: 2
   ```

### **Unpacking Example**
1. Unpacking the `packed_file.pck`:
   ```bash
   Enter the name of the packed file: packed_file.pck
   ```
   Output:
   ```
   File extracted with name: file1.txt
   File extracted with name: file2.txt
   Number of files successfully extracted: 2
   ```

---

## **File Structure**
```plaintext
.
├── PackUnpack.java   # Main Java program
├── example_dir/      # Example directory with `.txt` files (for packing)
├── packed_file.pck   # Example packed file (output of packing)
```

---

## **Limitations**
- Handles only `.txt` files for packing.
- Headers are fixed at 100 bytes and padded with spaces.
- Requires sufficient memory for large files.

---

## **Future Enhancements**
- Support for other file formats (e.g., `.csv`, `.log`).
- Dynamic header size with delimiters for better flexibility.
- Enhanced error handling and logging.
- Graphical User Interface (GUI) for easier interaction.
- Unit tests for robust functionality.

---
