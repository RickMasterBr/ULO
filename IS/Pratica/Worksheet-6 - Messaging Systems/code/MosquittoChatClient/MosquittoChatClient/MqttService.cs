using System;
using System.Threading.Tasks;
using MQTTnet;

namespace MosquittoChatClient;

public class MqttService
{
    private readonly IMqttClient _client;

    public event Action<string, string>? MessageReceived; // (topic, payload)

    public MqttService()
    {
        var factory = new MqttClientFactory();
        _client = factory.CreateMqttClient();
        _client.ApplicationMessageReceivedAsync += e =>
        {
            string topic = e.ApplicationMessage.Topic;
            string payload = e.ApplicationMessage.ConvertPayloadToString();

            MessageReceived?.Invoke(topic, payload);
            return Task.CompletedTask;
        };
    }

    public async Task Connect()
    {
        var options = new MqttClientOptionsBuilder()
            .WithTcpServer("localhost", 1883) // host + port
            .Build();

        await _client.ConnectAsync(options);
    }

    public async Task Subscribe(string topic)
    {
        await _client.SubscribeAsync(topic);
    }

    public async Task Publish(string topic, string message)
    {
        var mqttMessage = new MqttApplicationMessageBuilder()
        .WithTopic(topic)
        .WithPayload(message)
        .WithQualityOfServiceLevel(MQTTnet.Protocol.MqttQualityOfServiceLevel.AtLeastOnce)
        .Build();

        await _client.PublishAsync(mqttMessage);
    }

    public async Task Unsubscribe(string[] topics)
    {
        var builder = new MqttClientUnsubscribeOptionsBuilder();

        foreach (string topic in topics)
            builder.WithTopicFilter(topic);

        await _client.UnsubscribeAsync(builder.Build());
    }

    public async Task Disconnect()
    {
        if (_client is not null)
            await _client.DisconnectAsync();
    }

    public bool IsConnected => _client.IsConnected;
}
