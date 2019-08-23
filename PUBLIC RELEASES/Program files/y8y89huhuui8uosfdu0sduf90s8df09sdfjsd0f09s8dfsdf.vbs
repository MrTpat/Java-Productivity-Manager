WebsitesToBlock = Array("www.reddit.com", "www.youtube.com")
If WScript.Arguments.length =0 Then
	Set objShell = CreateObject("Shell.Application")
	objShell.ShellExecute "wscript.exe", Chr(34) & WScript.ScriptFullName & Chr(34) & " RunAsAdministrator", "", "runas", 1
Else
	Const ForReading = 1, ForWriting = 2
	
	Set shell = CreateObject("WScript.Shell")    
	root = shell.ExpandEnvironmentStrings("%systemroot%")     
	hostFile = root & "\system32\drivers\etc\hosts"
	tempFile = hostFile & ".bak"
	
	blocked = 0
	towrite = false
	
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set f1 = fso.OpenTextFile(hostFile, ForReading, True)
	Set f2 = fso.OpenTextFile(tempFile, ForWriting, True)
	
	Do Until f1.AtEndOfStream
	
		line = f1.Readline
		towrite = true
	
		For Each URL in WebsitesToBlock
			If instr(line, URL) Then
				If blocked = 0 Then 
					If left(line, 1) = "#" Then blocked = 1 Else blocked = 2
				End If
			towrite = false
			End If
		Next	
		
		If towrite Then f2.WriteLine line
	Loop
	
	For Each URL in WebsitesToBlock
		If blocked <> 2 Then
			f2.WriteLine "127.0.0.1" & vbTab & vbTab & URL 
		End If
	Next
	
	fso.Copyfile tempFile, hostFile
	
	f1.Close
	f2.Close
	
	If blocked = 2 Then 
		WScript.echo "Time wasting websites have now been unblocked on this computer" 
	Else
		WScript.echo "Time wasting websites are now blocked on this computer!" 
	End If

End If

' By Amit Agarwal http://www