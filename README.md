# Torrent
* The tracker stores a list of files and information about active users who have certain files (perhaps not entirely).
* Using the client application, you can view the list of files on the tracker, as well as add new ones and select files from the list for download.
* Files are conditionally divided into consecutive blocks of binary data of constant size (for example, 10M). The last block may be smaller. Blocks are numbered from zero.

---

# Torrent
* When connecting, the client sends a list of files distributed by it to the tracker.
* When downloading a file, the client receives from the tracker information about the clients distributing the file (seeds), and then communicates with them directly.
* From an individual seed, you can find out what full parts it has, as well as download them.
* After downloading individual blocks of a certain file, the client becomes a seed.

---
# Client Interface
* `upload [FILENAME]` -- client can upload file
* `list` -- the client can find out the files being distributed
* `download [ID]` -- the client can download the file he likes

---
# Torrent-tracker
* Keeps meta-information about distributed files:
    * identificator
    * active clients (there was an update recently) that have this file in whole or some parts of it
* Server's port: 8081
* Requests:
    * `list` — list of distributed files
    * `upload` — publishing a new file
    * `sources` — a list of clients who own certain files in whole or in part
    * `update` — downloading by the client of data about the files being distributed
    
---
# List
* Request format:

* Request answer:
    * (FileContent: id, name, size)*,
    * id — identificator of file
    * name — file name
    * size — size of file

---
# Upload
* Request format:
    * filename, size, userInfo
    * filename — file name
    * size — size of file
    * UserInfo: ip, port -- information about the client
* Request answer:
    * FileContent: id, size, name — information about the file

# Note
* If client A and client B decide to publish the abc.txt file, then these will be **different** files, in other words, each request to publish the file returns a **new** id

---

# Sources

* Request format:
    * <3: Byte> <id: Int>,
    * id — identificator of file
* Request answer:
    * idFile (UserInfo)*,
    * UserInfo: ip, port -- information about the client
    * id — id file
---

# Update

* Request format:
    * userInfo, portOfClientServer, (fileContent)*,
    * userInfo — client port,
    * portOfClientServer — client-server port
    * fileContent — information about the file
* Request answer:
    * <status: Boolean>,
    * status — True, if the information is successfully updated

# Note
* The client is obliged to execute this request every 5 minutes, otherwise the server considers that the client has left the distribution
---
# Torrent-client
* The client port is specified at startup and passed to the tracker as part of the update request
* Each file is distributed in parts, the size of the part is a constant for the entire application
* The client stores and distributes these very parts
* Requests:
    * stat — parts of a particular file available for distribution
    * get — download part of a specific file

---

# Stat

* Request format:
    * <1: Byte> <id: Int>,
    * id — identificator of file
* Request answer:
    * userInfo idFile (<part: Int>)*,
    * userInfo -- information about the client
    * idFile — id file
    * part — part number

# Note

* A part is considered available for distribution if it is stored entirely on the client
---
# Get
* Request format:
    * <2: Byte> <id: Int> <part: Int>
    * id — identificator of file,
    * part — part number
* Request answer:
    * <content: Bytes>,
    * content — part content
    * fileContent -- information about which file
    * partOfFile -- what part of the file
---

# Requirements:
* Gradle project
* Console tracker and client that allow you to execute the specified requests
* Tests
* Documentation of your application's artifact build process
     * Ideally, I would like these artifacts to be two shell scripts
       (one for running the client, the other for the server)
     * However, two executable jar files will also be enough
* The client must save information about the distributed files between restarts
* The tracker should save the list of distributed files between restarts

# run
* tracker.sh -- run tracker
* client.sh -- start the client, inside the script change the port number for the multi-user version

