/****** Object:  Schema [SalesLT]    Script Date: 12/4/2022 5:48:09 PM ******/
CREATE SCHEMA [SalesLT]
    GO
/****** Object:  Table [dbo].[admin]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[admin](
    [id] [uniqueidentifier] NOT NULL,
     PRIMARY KEY CLUSTERED
    (
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[BuildVersion]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[BuildVersion](
    [SystemInformationID] [tinyint] IDENTITY(1,1) NOT NULL,
    [Database Version] [nvarchar](25) NOT NULL,
    [VersionDate] [datetime] NOT NULL,
    [ModifiedDate] [datetime] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[SystemInformationID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[client]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[client](
    [id] [uniqueidentifier] NOT NULL,
     PRIMARY KEY CLUSTERED
    (
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[device]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[device](
    [id] [uniqueidentifier] NOT NULL,
    [address] [varchar](255) NULL,
    [description] [varchar](255) NULL,
    [hourly_consumption_limit] [float] NOT NULL,
    [name] [varchar](255) NOT NULL,
    [client_id] [uniqueidentifier] NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[ErrorLog]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[ErrorLog](
    [ErrorLogID] [int] IDENTITY(1,1) NOT NULL,
    [ErrorTime] [datetime] NOT NULL,
    [UserName] [sysname] NOT NULL,
    [ErrorNumber] [int] NOT NULL,
    [ErrorSeverity] [int] NULL,
    [ErrorState] [int] NULL,
    [ErrorProcedure] [nvarchar](126) NULL,
    [ErrorLine] [int] NULL,
    [ErrorMessage] [nvarchar](4000) NOT NULL,
    CONSTRAINT [PK_ErrorLog_ErrorLogID] PRIMARY KEY CLUSTERED
(
[ErrorLogID] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[measurement]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[measurement](
    [id] [uniqueidentifier] NOT NULL,
    [datetime] [datetime] NOT NULL,
    [energy_consumption] [float] NOT NULL,
    [device_id] [uniqueidentifier] NOT NULL,
     PRIMARY KEY CLUSTERED
    (
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
/****** Object:  Table [dbo].[users]    Script Date: 12/4/2022 5:48:09 PM ******/
    SET ANSI_NULLS ON
    GO
    SET QUOTED_IDENTIFIER ON
    GO
CREATE TABLE [dbo].[users](
    [id] [uniqueidentifier] NOT NULL,
    [email_address] [varchar](255) NOT NULL,
    [password] [varchar](255) NOT NULL,
    [user_name] [varchar](255) NOT NULL,
    PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
    INSERT [dbo].[admin] ([id]) VALUES (N'd92bb40f-bbb0-4b91-9b46-b409f7e77e84')
    GO
    SET IDENTITY_INSERT [dbo].[BuildVersion] ON
    GO
    INSERT [dbo].[BuildVersion] ([SystemInformationID], [Database Version], [VersionDate], [ModifiedDate]) VALUES (1, N'10.50.91013.00', CAST(N'2009-10-13T00:00:00.000' AS DateTime), CAST(N'2009-10-13T00:00:00.000' AS DateTime))
    GO
    SET IDENTITY_INSERT [dbo].[BuildVersion] OFF
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'6fdc9cc4-2098-4ac4-aacd-03ea9eed36d9')
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'0f0568ec-29eb-413a-8c71-2f71c98da0e9')
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'2c6a00ed-9284-477a-9581-5e01e5f1e2b1')
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'ba7d4b93-7257-43e7-9b8b-7303f102ee96')
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'd5dc6fb7-7868-422f-93ad-791b9af8dc69')
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'40479ec2-6bfa-4929-ac1e-87c945206255')
    GO
    INSERT [dbo].[client] ([id]) VALUES (N'44c57613-8792-422f-8c60-98b235e4336f')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'55614479-ce54-46a5-8a37-1c1b324d12d1', NULL, NULL, 5000, N'Device4', N'd5dc6fb7-7868-422f-93ad-791b9af8dc69')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'2097f8e7-c398-48cf-a349-2e575e3eab5d', NULL, NULL, 10000, N'Device3', N'2c6a00ed-9284-477a-9581-5e01e5f1e2b1')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'9c9f4e93-cbc0-4fb1-b27b-6e65daf796ad', NULL, NULL, 5000, N'Device1', N'2c6a00ed-9284-477a-9581-5e01e5f1e2b1')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'681efbcf-9530-4960-9462-7d48b5214851', NULL, NULL, 5000, N'Device2', N'd5dc6fb7-7868-422f-93ad-791b9af8dc69')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'826734da-d9ae-49f9-b3de-944602345fbb', NULL, NULL, 15, N'Device7', N'2c6a00ed-9284-477a-9581-5e01e5f1e2b1')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'75e6ce0f-6296-4869-b773-fb5cb9b15088', NULL, N'd5d5d5d5d5', 15, N'Device6', N'2c6a00ed-9284-477a-9581-5e01e5f1e2b1')
    GO
    INSERT [dbo].[device] ([id], [address], [description], [hourly_consumption_limit], [name], [client_id]) VALUES (N'3ccf1c2c-0e05-4558-8cfc-fe065b42c908', NULL, NULL, 20, N'Device5', N'd5dc6fb7-7868-422f-93ad-791b9af8dc69')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'e358f924-2f70-43f3-ad52-0f1cb74e21c0', CAST(N'2022-12-04T13:00:00.000' AS DateTime), 4687.1200902199989, N'3ccf1c2c-0e05-4558-8cfc-fe065b42c908')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'361cebc7-0c3c-48d0-963b-10b83873bff3', CAST(N'2022-12-04T02:00:00.000' AS DateTime), 13622.916330819999, N'2097f8e7-c398-48cf-a349-2e575e3eab5d')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'a656ae92-5651-445d-b09f-141f5604635c', CAST(N'2022-12-04T14:00:00.000' AS DateTime), 1281185.9607447004, N'55614479-ce54-46a5-8a37-1c1b324d12d1')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'ba50b8f6-5206-45fb-8cbf-351a99ecd0dd', CAST(N'2022-12-04T17:00:00.000' AS DateTime), 6723312.8558599977, N'55614479-ce54-46a5-8a37-1c1b324d12d1')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'1344ec78-c2ea-4b10-a12a-3c5edb19b514', CAST(N'2022-12-04T17:00:00.000' AS DateTime), 6765186.24429, N'3ccf1c2c-0e05-4558-8cfc-fe065b42c908')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'49ee7617-f078-4625-ae6b-428c031783ff', CAST(N'2022-12-04T01:00:00.000' AS DateTime), 12391.228940850002, N'681efbcf-9530-4960-9462-7d48b5214851')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'41dc6c59-ec40-4e99-9738-5b6deee613f3', CAST(N'2022-12-04T14:00:00.000' AS DateTime), 1370737.6885832, N'3ccf1c2c-0e05-4558-8cfc-fe065b42c908')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'56d8e6dd-b37f-4963-9d0f-5d185fd4ac3c', CAST(N'2022-12-04T01:00:00.000' AS DateTime), 87.69236017, N'9c9f4e93-cbc0-4fb1-b27b-6e65daf796ad')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'ea15dae6-b13b-4525-8cc2-6e0f0653e556', CAST(N'2022-12-04T15:00:00.000' AS DateTime), 3773570.0934150009, N'75e6ce0f-6296-4869-b773-fb5cb9b15088')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'fa24590d-34c5-4e1e-96e0-711ee6b5f225', CAST(N'2022-12-04T15:00:00.000' AS DateTime), 3746409.5241070003, N'3ccf1c2c-0e05-4558-8cfc-fe065b42c908')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'a5e3bb18-e2e3-4970-9ba9-8687238df86e', CAST(N'2022-11-29T15:00:00.000' AS DateTime), 22.9294086, N'681efbcf-9530-4960-9462-7d48b5214851')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'77ff266f-6462-4c1a-bf09-91e95acda52d', CAST(N'2022-12-04T16:00:00.000' AS DateTime), 6174452.1206100043, N'55614479-ce54-46a5-8a37-1c1b324d12d1')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'06fecdd0-d3ab-47c5-8583-a8fcfd346efc', CAST(N'2022-12-04T17:00:00.000' AS DateTime), 6786089.76167, N'75e6ce0f-6296-4869-b773-fb5cb9b15088')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'2da69819-56da-4c71-a212-a9b187af7d28', CAST(N'2022-12-04T02:00:00.000' AS DateTime), 92.432494519999992, N'9c9f4e93-cbc0-4fb1-b27b-6e65daf796ad')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'023d24ca-78a6-4628-9dea-bf7534d14f91', CAST(N'2022-12-04T13:00:00.000' AS DateTime), 945.62781572, N'55614479-ce54-46a5-8a37-1c1b324d12d1')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'793ad73d-0db7-41a9-abbb-ce8450e83e31', CAST(N'2022-11-29T14:00:00.000' AS DateTime), 707264.08077574987, N'681efbcf-9530-4960-9462-7d48b5214851')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'b5eb7b4e-ebaa-4f9f-9f94-d3f37d3c3856', CAST(N'2022-12-04T14:00:00.000' AS DateTime), 7, N'826734da-d9ae-49f9-b3de-944602345fbb')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'e32a888c-eb6b-4da9-99b4-daf73e9187ed', CAST(N'2022-12-04T14:00:00.000' AS DateTime), 1397449.1326907, N'75e6ce0f-6296-4869-b773-fb5cb9b15088')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'ba728f73-0ef1-49a0-8a6b-e19f4c6e199e', CAST(N'2022-12-04T16:00:00.000' AS DateTime), 6256206.2369300025, N'75e6ce0f-6296-4869-b773-fb5cb9b15088')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'1b1e0614-b406-4785-a6fa-e8820e77381e', CAST(N'2022-12-04T13:00:00.000' AS DateTime), 6394.1648247199992, N'75e6ce0f-6296-4869-b773-fb5cb9b15088')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'eb248979-2167-4944-b66d-f093c132f732', CAST(N'2022-12-04T15:00:00.000' AS DateTime), 3678632.8016420011, N'55614479-ce54-46a5-8a37-1c1b324d12d1')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'828e3f79-3811-4798-b285-f2c384d8de3e', CAST(N'2022-11-29T01:00:00.000' AS DateTime), 278675.10643684008, N'9c9f4e93-cbc0-4fb1-b27b-6e65daf796ad')
    GO
    INSERT [dbo].[measurement] ([id], [datetime], [energy_consumption], [device_id]) VALUES (N'b1db2d4c-1845-4f95-9583-fe4235d14320', CAST(N'2022-12-04T16:00:00.000' AS DateTime), 6229068.7793000024, N'3ccf1c2c-0e05-4558-8cfc-fe065b42c908')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'6fdc9cc4-2098-4ac4-aacd-03ea9eed36d9', N'Hubabuba22@gmail.com', N'$2a$10$t1XGhAviHeuP5IsTTCHtH.MJaeLKakkG8BB34/Dv2p/n53dRPFnIa', N'Huba')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'0f0568ec-29eb-413a-8c71-2f71c98da0e9', N'b@b.com', N'$2a$10$uwdusQENRP7sKCbUzaZJPeW7HrnMLs5eb1HStq0Gu/I0yUBzTPdr.', N'bori')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'2c6a00ed-9284-477a-9581-5e01e5f1e2b1', N'c@c.com', N'$2a$10$TJip1BwKcDGMQWdG/evpl.t1lICvFZ6CKynfMwS0epOvRQjrZ7q1i', N'client2')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'ba7d4b93-7257-43e7-9b8b-7303f102ee96', N'c@c.com', N'$2a$10$Il2Kxeg1NHqmpseMRdxa5OIPz.u/WN.NnXuU8En.DnxEIZuSpE6gm', N'client3')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'd5dc6fb7-7868-422f-93ad-791b9af8dc69', N'client@c.com', N'$2a$10$CT.N8CkJ0UDmjUM45.L49.98Ih/NL5HhOvav9oCd.61NuvHi3..O.', N'client1')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'40479ec2-6bfa-4929-ac1e-87c945206255', N'semeriuss@gmail.com', N'$2a$10$rv8ncdCcByvtQtOT7jxeXupBV4AkjH.oP7ow8qq6o.SAcfjCGZJsS', N'Semeriuss')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'44c57613-8792-422f-8c60-98b235e4336f', N'zsuzsidarvay@gmail.com', N'$2a$10$fmRU32NJsXrQ1HYn9pfaROt0hadlW74ItRhmfdFJlVdE.i9Ndg4cm', N'DZsuzsi')
    GO
    INSERT [dbo].[users] ([id], [email_address], [password], [user_name]) VALUES (N'd92bb40f-bbb0-4b91-9b46-b409f7e77e84', N'a@a.com', N'$2a$10$AWoQ87U9lB3QSq0hlHdGS.bG4Pvt2GsZ6CCcLZKUOYbKqxp3PPB/C', N'admin')
    GO
ALTER TABLE [dbo].[BuildVersion] ADD  CONSTRAINT [DF_BuildVersion_ModifiedDate]  DEFAULT (getdate()) FOR [ModifiedDate]
    GO
ALTER TABLE [dbo].[ErrorLog] ADD  CONSTRAINT [DF_ErrorLog_ErrorTime]  DEFAULT (getdate()) FOR [ErrorTime]
    GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD  CONSTRAINT [FKqer4e53tfnl17s22ior7fcsv8] FOREIGN KEY([id])
    REFERENCES [dbo].[users] ([id])
    GO
ALTER TABLE [dbo].[admin] CHECK CONSTRAINT [FKqer4e53tfnl17s22ior7fcsv8]
    GO
ALTER TABLE [dbo].[client]  WITH CHECK ADD  CONSTRAINT [FK70dfjxvqnmgixqht3vea50voj] FOREIGN KEY([id])
    REFERENCES [dbo].[users] ([id])
    GO
ALTER TABLE [dbo].[client] CHECK CONSTRAINT [FK70dfjxvqnmgixqht3vea50voj]
    GO
ALTER TABLE [dbo].[device]  WITH CHECK ADD  CONSTRAINT [FKdu2w3cqp9s5nydbum1dkl1wcb] FOREIGN KEY([client_id])
    REFERENCES [dbo].[client] ([id])
    GO
ALTER TABLE [dbo].[device] CHECK CONSTRAINT [FKdu2w3cqp9s5nydbum1dkl1wcb]
    GO
ALTER TABLE [dbo].[measurement]  WITH CHECK ADD  CONSTRAINT [FKfk341lu27m89eohc71wnwf8bt] FOREIGN KEY([device_id])
    REFERENCES [dbo].[device] ([id])
    GO
ALTER TABLE [dbo].[measurement] CHECK CONSTRAINT [FKfk341lu27m89eohc71wnwf8bt]
    GO
