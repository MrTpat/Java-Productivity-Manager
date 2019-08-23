@echo off
taskkill /f /im microsoftedge.exe
taskkill /f /im chrome.exe
taskkill /f /im firefox.exe
netsh interface set interface "Local Area Connection " ENABLE
netsh interface set interface "Local Area Connection " DISABLE
exit