using System;
using System.Threading.Tasks;
using Avalonia.Controls;
using Avalonia.Media;
using Avalonia.Threading;

namespace MosquittoChatClient;

public partial class MainWindow : Window
{
    private readonly MqttService _mqtt = new();
    public MainWindow()
    {
        InitializeComponent();

        ConnectButton.Click += ConnectButton_Click;
        SendButton.Click += SendButton_Click;
        Closed += MainWindow_Closed;

        _mqtt.MessageReceived += (topic, payload) =>
        {
            Dispatcher.UIThread.Post(() =>
            {
                string[] parts = payload.Split('|');
                if (parts.Length >= 3)
                {
                    string nickname = parts[0];
                    string classroom = parts[1];
                    string payload = parts[2];

                    MessageArea.Text += $"Channel {classroom}: {nickname} - {payload}\n";
                    MessageArea.CaretIndex = MessageArea.Text.Length;
                }
                else
                {
                    // Invalid message format
                    MessageArea.Text += payload + "\n";
                }
            });
        };

        SetStatus(false);
    }

    private void SetStatus(bool connected)
    {
        StatusLabel.Text = connected ? "Connection status: connected"
                                     : "Connection status: disconnected";

        StatusLabel.Foreground = connected ? Brushes.Green : Brushes.Red;
    }

    private async void ConnectButton_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
    {
        string? topic = ClassroomBox.Text;

        if (string.IsNullOrWhiteSpace(topic))
        {
            MessageArea.Text += "Classroom/topic is empty.\n";
            return;
        }

        try
        {
            await _mqtt.Connect();
            await _mqtt.Subscribe(topic);

            MessageArea.Text += $"Connected and subscribed to {topic}\n";

            SetStatus(true);
        }
        catch (Exception ex)
        {
            MessageArea.Text += $"Connection failed: {ex.Message}\n";

            SetStatus(false);
        }
    }

    private async void MainWindow_Closed(object? sender, EventArgs e)
    {
        if (_mqtt.IsConnected)
            await _mqtt.Disconnect();

        SetStatus(false);
    }

    private async void SendButton_Click(object? sender, Avalonia.Interactivity.RoutedEventArgs e)
    {
        if (!_mqtt.IsConnected)
        {
            MessageArea.Text += "Not connected.\n";
            return;
        }

        string? topic = ClassroomBox.Text;
        string payload = MessageInput.Text?.Trim() ?? "";

        if (payload.Length == 0)
        {
            Console.WriteLine("Message is empty.");
            return;
        }

        string strMsgToSend = NicknameBox.Text + "|" + ClassroomBox.Text + "|" + payload;

        Console.WriteLine("Now sending...");
        await _mqtt.Publish(topic, strMsgToSend);

        MessageInput.Text = string.Empty;
    }
}