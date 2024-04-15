package ir.utux

import java.nio.file.Files
import java.nio.file.Paths

// ترجمه و ذخیره فایل زیرنویس
def translateAndSaveSubtitle(String filePath, String firstLanguage, String secondLanguage) {
    final TRANSLATE_WEBSITE = "https://www.webtran.eu"
    println filePath
    try {
        def content = new File(filePath).text

        def formData = [
                "x1": "Ares",
                "x2": content,
                "x3": firstLanguage,
                "x4": secondLanguage
        ]

        def postData = encodeFormData(formData)

        def url = new URL(TRANSLATE_WEBSITE + "/oldman/")
        def connection = (HttpURLConnection) url.openConnection()
        connection.with {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/x-www-form-urlencoded")
            setRequestProperty("Content-Length", Integer.toString(postData.bytes.length))
            doOutput = true

            def writer = new OutputStreamWriter(outputStream)
            writer.with {
                write(postData)
                flush()
            }

            def responseCode = responseCode
            println "Response code: $responseCode"

            def response = new StringBuilder()
            new BufferedReader(new InputStreamReader(inputStream)).eachLine { line ->
                response.append('\n'+line)
            }

            def newFileName = getNewFileName(filePath)
            Files.write(Paths.get(newFileName), response.toString().bytes)
            println "Translation saved to: $newFileName"
        }
    } catch (IOException e) {
        e.printStackTrace()
    }
}

// بررسی مسیر فایل معتبر
def isValidSubtitleFile(String fileName) {
    final SUPPORTED_EXTENSIONS = ["srt", "vtt", "ass"]
    SUPPORTED_EXTENSIONS.any { fileName.toLowerCase().endsWith(".$it") }
}

// دریافت نام جدید برای فایل ترجمه شده
def getNewFileName(String originalFileName) {
    def lastIndex = originalFileName.lastIndexOf('.')
    def extension = originalFileName.substring(lastIndex + 1)
    def fileNameWithoutExtension = originalFileName.substring(0, lastIndex)
    return "$fileNameWithoutExtension"+"_translate"+".$extension"
}

// تبدیل Map به رشته FormData
String encodeFormData(Map<String, String> formData) {
    formData.collect { k, v -> "$k=${URLEncoder.encode(v, 'UTF-8')}" }.join('&')
}

// استفاده از توابع پیش‌فرض برای زبان‌ها
def firstLanguage = args.length > 1 ? args[1] : "en"
def secondLanguage = args.length > 2 ? args[2] : "fa"

// اسامی فایل‌ها را از آرگومان‌های دستوری بدست می‌آوریم
def directoryPath = args[0]
def directory = new File(directoryPath)
def files = directory.listFiles()

System.getProperties().put("proxySet", "true");
System.getProperties().put("proxyHost", "127.0.0.1");
System.getProperties().put("proxyPort", "2081");
files.each { file ->
    // اگر فایل با پسوند معتبر باشد، آن را ترجمه کن
    if (file.isFile() && isValidSubtitleFile(file.name)) {
        translateAndSaveSubtitle(file.absolutePath, firstLanguage, secondLanguage)
        Thread.sleep(10000)
    } else {
        println "Unsupported file format: ${file.name}"
    }
}
//
//     این کد یک اسکریپت  Groovy است که فایل‌های زیرنویس را ترجمه می‌کند. این اسکریپت از  Webtran.eu برای ترجمه استفاده می‌کند.
//     برای اجرای این اسکریپت، ابتدا  Groovy را نصب کنید. سپس کد بالا را در  Main.groovy  ذخیره کنید. برای اجرای این اسکریپت، از دستور زیر استفاده کنید:
//     groovy Main.groovy /path/to/subtitles/directory [firstLanguage] [secondLanguage]
//
//     در اینجا،  /path/to/subtitles/directory  مسیر دایرکتوری حاوی فایل‌های زیرنویس است.  firstLanguage  و  secondLanguage  زبان‌هایی هستند که می‌خواهید از  firstLanguage  به  secondLanguage  ترجمه شوند. اگر این دو زبان مشخص نشوند، زبان‌های پیش‌فرض انگلیسی و فارسی استفاده می‌شوند.
//     این اسکریپت فایل‌های زیرنویس را ترجمه کرده و فایل‌های ترجمه شده را در همان دایرکتوری ذخیره می‌کند.